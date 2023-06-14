/**
给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目： 

 
 0 <= i < j < k < nums.length 
 nums[i]、nums[j] 和 nums[k] 两两不同 。 
 
 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
 
 

 返回满足上述条件三元组的数目。 

 

 示例 1： 

 
输入：nums = [4,4,2,4,3]
输出：3
解释：下面列出的三元组均满足题目条件：
- (0, 2, 4) 因为 4 != 2 != 3
- (1, 2, 4) 因为 4 != 2 != 3
- (2, 3, 4) 因为 2 != 4 != 3
共计 3 个三元组，返回 3 。
注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 

 示例 2： 

 
输入：nums = [1,1,1,1,1]
输出：0
解释：不存在满足条件的三元组，所以返回 0 。
 

 

 提示： 

 
 3 <= nums.length <= 100 
 1 <= nums[i] <= 1000 
 

 Related Topics 数组 哈希表 👍 71 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhiheng
 */
public class NumberOfUnequalTripletsInArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int unequalTriplets(int[] nums) {
            if (nums.length < 3 ||
                    Arrays.stream(nums).distinct().toArray().length < 3) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int ans = 0; int a = 0;
            int n = nums.length;
            for (Integer b : map.values()) {
                ans += a * b * (n - a - b);
                a += b;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfUnequalTripletsInArray().new Solution();
    }
}