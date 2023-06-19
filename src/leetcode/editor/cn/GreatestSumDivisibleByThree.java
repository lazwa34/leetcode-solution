/**
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 

 
 

 

 示例 1： 

 输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 

 示例 2： 

 输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 

 示例 3： 

 输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 

 

 提示： 

 
 1 <= nums.length <= 4 * 10^4 
 1 <= nums[i] <= 10^4 
 

 Related Topics 贪心 数组 动态规划 排序 👍 227 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

/**
 * @author wangzhiheng
 */
public class GreatestSumDivisibleByThree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            List<Integer>[] list = new List[3];
            list[1] = new ArrayList<>();
            list[2] = new ArrayList<>();
            int res = 0;
            for (int num : nums) {
                if (num % 3 != 0) {
                    list[num%3].add(num);
                }
                res += num;
            }
            Collections.sort(list[1]);
            Collections.sort(list[2]);

            if (res % 3 == 1) {
                if (list[1].size() > 0 && list[2].size() > 1) {
                    res = Math.max(res - list[1].get(0), res - list[2].get(0) - list[2].get(1));
                } else if (list[1].size() > 0) {
                    res -= list[1].get(0);
                } else if (list[2].size() > 1) {
                    res -= (list[2].get(0) + list[2].get(1));
                }
            }
            if (res % 3 == 2) {
                if (list[1].size() > 1 && list[2].size() > 0) {
                    res = Math.max(res - list[1].get(0) - list[1].get(1), res - list[2].get(0));
                } else if (list[1].size() > 1) {
                    res -= (list[1].get(0) + list[1].get(1));
                } else if (list[2].size() > 0) {
                    res -= list[2].get(0);
                }
            }
            if (res % 3 != 0) {
                return 0;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{3,6,5,1,8}));
    }
}