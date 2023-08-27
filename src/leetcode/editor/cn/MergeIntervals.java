/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 

 Related Topics 数组 排序 👍 2023 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangzhiheng
 * @date 2023-08-27 11:37:58
 */
public class MergeIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[][]{};
            }
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            int index = 0;
            int[][] res = new int[intervals.length][];
            res[0] = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] tag = res[index];
                if (intervals[i][0] > tag[1]) {
                    index++;
                    res[index] = intervals[i];
                } else {
                    tag[1] = Math.max(tag[1], intervals[i][1]);
                    res[index] = tag;
                }
            }
            return Arrays.copyOf(res, index + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(
                new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
        )));
    }
}