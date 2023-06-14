/**
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 

 你返回所有和为 0 且不重复的三元组。 

 注意：答案中不可以包含重复的三元组。 

 

 

 示例 1： 

 
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
 

 示例 2： 

 
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
 

 示例 3： 

 
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 

 

 提示： 

 
 3 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 双指针 排序 👍 6004 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhiheng
 */
public class ThreeSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums.length < 3 || nums == null) {
                return list;
            }

            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[r] + nums[l] + nums[i];
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[l], nums[i], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++; r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{1, 2, -3}));
    }
}