//<p>给你一个下标从 <strong>0</strong>&nbsp;开始的二维整数数组&nbsp;<code>flowers</code>&nbsp;，其中&nbsp;<code>flowers[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>&nbsp;表示第&nbsp;<code>i</code>&nbsp;朵花的 <strong>花期</strong>&nbsp;从&nbsp;<code>start<sub>i</sub></code>&nbsp;到&nbsp;<code>end<sub>i</sub></code>&nbsp;（都 <strong>包含</strong>）。同时给你一个下标从 <strong>0</strong>&nbsp;开始大小为 <code>n</code>&nbsp;的整数数组&nbsp;<code>people</code> ，<code>people[i]</code>&nbsp;是第&nbsp;<code>i</code>&nbsp;个人来看花的时间。</p>
//
//<p>请你返回一个大小为 <code>n</code>&nbsp;的整数数组<em>&nbsp;</em><code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>是第&nbsp;<code>i</code>&nbsp;个人到达时在花期内花的&nbsp;<strong>数目</strong>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/ex1new.jpg" style="width: 550px; height: 216px;" /></p>
//
//<pre>
//<b>输入：</b>flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//<b>输出：</b>[1,2,2,2]
//<strong>解释：</strong>上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/ex2new.jpg" style="width: 450px; height: 195px;" /></p>
//
//<pre>
//<b>输入：</b>flowers = [[1,10],[3,3]], people = [3,3,2]
//<b>输出：</b>[2,2,1]
//<b>解释：</b>上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= flowers.length &lt;= 5 * 10<sup>4</sup></code></li> 
// <li><code>flowers[i].length == 2</code></li> 
// <li><code>1 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>9</sup></code></li> 
// <li><code>1 &lt;= people.length &lt;= 5 * 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= people[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>二分查找</li><li>有序集合</li><li>前缀和</li><li>排序</li></div></div><br><div><li>👍 73</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.*;

/**
 * @author wangzhiheng
 * @date 2023-09-28 08:51:48
 */
public class NumberOfFlowersInFullBloom {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            List<Integer> in = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            for (int[] flower : flowers) {
                in.add(flower[0]);
                out.add(flower[1]);
            }
            Collections.sort(in);
            Collections.sort(out);
            int[][] t = new int[people.length][2];
            for (int i = 0; i < people.length; i++) {
                t[i][0] = people[i];
                t[i][1] = i;
            }
            Arrays.sort(t, Comparator.comparingInt(a -> a[0]));
            int idx1 = 0, idx2 = 0;
            int[] ret = new int[people.length];
            int cur = 0;
            for (int i = 0; i < t.length; i++) {
                while (idx1 < in.size() && in.get(idx1) <= t[i][0]) {
                    cur += 1;
                    idx1++;
                }
                while (idx2 < out.size() && out.get(idx2) < t[i][0]) {
                    cur -= 1;
                    idx2++;
                }
                ret[t[i][1]] = cur;
            }

            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfFlowersInFullBloom().new Solution();
        System.out.println(Arrays.toString(solution.fullBloomFlowers(
                new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11}
        )));
    }
}