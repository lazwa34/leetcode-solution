//<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，数组中的元素都是 <strong>正</strong> 整数。请你选出两个下标 <code>i</code> 和 <code>j</code>（<code>i != j</code>），且 <code>nums[i]</code> 的数位和 与&nbsp; <code>nums[j]</code> 的数位和相等。</p>
//
//<p>请你找出所有满足条件的下标 <code>i</code> 和 <code>j</code> ，找出并返回<em> </em><code>nums[i] + nums[j]</code><em> </em>可以得到的 <strong>最大值</strong> <em>。</em></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [18,43,36,13,7]
//<strong>输出：</strong>54
//<strong>解释：</strong>满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [10,12,19,14]
//<strong>输出：</strong>-1
//<strong>解释：</strong>不存在满足条件的数对，返回 -1 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 47</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhiheng
 * @date 2023-11-18 14:16:47
 */
public class MaxSumOfAPairWithEqualSumOfDigits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
            Arrays.sort(nums);
            int max = -1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int v = getSum(num);
                if (!map.containsKey(v)) {
                    map.put(v, num);
                } else {
                    max = Math.max(max, map.get(v) + num);
                    map.put(v, num);
                }
            }
            return max;
        }

        public int getSum(int value) {
            int sum = 0;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaxSumOfAPairWithEqualSumOfDigits().new Solution();
        System.out.println(solution.maximumSum(new int[]{18, 43, 36, 13, 7}));
    }
}