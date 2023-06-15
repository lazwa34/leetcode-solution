/**
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b],
 nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 

 
 0 <= a, b, c, d < n 
 a、b、c 和 d 互不相同 
 nums[a] + nums[b] + nums[c] + nums[d] == target 
 

 你可以按 任意顺序 返回答案 。 

 

 示例 1： 

 
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 

 示例 2： 

 
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
 

 

 提示： 

 
 1 <= nums.length <= 200 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics 数组 双指针 排序 👍 1611 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhiheng
 */
public class FourSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return list;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 && nums[i] > target) break;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j-1]) continue;
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        int sum = nums[j] + nums[l] + nums[r];
                        if (sum == target - nums[i]) {
                            list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l+1]) l++;
                            while (l < r && nums[r] == nums[r-1]) r--;
                            l++; r--;
                        } else if (sum > target - nums[i]) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{-5,-4,-3,-2,1,3,3,5}, -11));
        // -5,-4,-3,1
    }
}