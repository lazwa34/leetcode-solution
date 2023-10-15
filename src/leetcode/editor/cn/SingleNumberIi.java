/**
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 

 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。 

 

 示例 1： 

 
输入：nums = [2,2,3,2]
输出：3
 

 示例 2： 

 
输入：nums = [0,1,0,1,0,1,99]
输出：99
 

 

 提示： 

 
 1 <= nums.length <= 3 * 10⁴ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
 

 Related Topics 位运算 数组 👍 1094 👎 0

*/

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhiheng
 * @date 2023-10-15 10:32:03
 */
public class SingleNumberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
        System.out.println(solution.singleNumber(
                new int[]{0,1,0,1,0,1,99}
        ));
    }
}