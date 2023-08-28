//<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 。对于每个下标 <code>i</code>（<code>1 &lt;= i &lt;= nums.length - 2</code>），<code>nums[i]</code> 的 <strong>美丽值</strong> 等于：</p>
//
//<ul> 
// <li><code>2</code>，对于所有 <code>0 &lt;= j &lt; i</code> 且 <code>i &lt; k &lt;= nums.length - 1</code> ，满足 <code>nums[j] &lt; nums[i] &lt; nums[k]</code></li> 
// <li><code>1</code>，如果满足 <code>nums[i - 1] &lt; nums[i] &lt; nums[i + 1]</code> ，且不满足前面的条件</li> 
// <li><code>0</code>，如果上述条件全部不满足</li> 
//</ul>
//
//<p>返回符合 <code>1 &lt;= i &lt;= nums.length - 2</code> 的所有<em> </em><code>nums[i]</code><em> </em>的 <strong>美丽值的总和</strong> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>nums = [1,2,3]
//<strong>输出：</strong>2
//<strong>解释：</strong>对于每个符合范围 1 &lt;= i &lt;= 1 的下标 i :
//- nums[1] 的美丽值等于 2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nums = [2,4,6,4]
//<strong>输出：</strong>1
//<strong>解释：</strong>对于每个符合范围 1 &lt;= i &lt;= 2 的下标 i :
//- nums[1] 的美丽值等于 1
//- nums[2] 的美丽值等于 0
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>nums = [3,2,1]
//<strong>输出：</strong>0
//<strong>解释：</strong>对于每个符合范围 1 &lt;= i &lt;= 1 的下标 i :
//- nums[1] 的美丽值等于 0
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 18</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-08-28 14:31:38
 */
public class SumOfBeautyInTheArray {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfBeauties(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        int[] stat = new int[nums.length];
        int max = nums[0], min = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (max < nums[i]) {
                stat[i] = 1;
                max = nums[i];
            }
        }
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                stat[i] = 0;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (stat[i] == 1) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SumOfBeautyInTheArray().new Solution();
        System.out.println(solution.sumOfBeauties(
                new int[]{1,2,3,4,5,7,8,9,10}
        ));
    }
}