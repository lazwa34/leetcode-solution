/**
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 

 返回这三个数的和。 

 假定每组输入只存在恰好一个解。 

 

 示例 1： 

 
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

 示例 2： 

 
输入：nums = [0,0,0], target = 1
输出：0
 

 

 提示： 

 
 3 <= nums.length <= 1000 
 -1000 <= nums[i] <= 1000 
 -10⁴ <= target <= 10⁴ 
 

 Related Topics 数组 双指针 排序 👍 1406 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 */
public class ThreeSumClosest {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 1; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[r] + nums[l] + nums[i];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    if (sum > target) {
                        while (l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1,1,1,0}, 100));
    }
}