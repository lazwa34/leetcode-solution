//<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和一个整数 <code>threshold</code> 。</p>
//
//<p>请你从 <code>nums</code> 的子数组中找出以下标 <code>l</code> 开头、下标 <code>r</code> 结尾 <code>(0 &lt;= l &lt;= r &lt; nums.length)</code> 且满足以下条件的 <strong>最长子数组</strong> ：</p>
//
//<ul> 
// <li><code>nums[l] % 2 == 0</code></li> 
// <li>对于范围&nbsp;<code>[l, r - 1]</code> 内的所有下标 <code>i</code> ，<code>nums[i] % 2 != nums[i + 1] % 2</code></li> 
// <li>对于范围&nbsp;<code>[l, r]</code> 内的所有下标 <code>i</code> ，<code>nums[i] &lt;= threshold</code></li> 
//</ul>
//
//<p>以整数形式返回满足题目要求的最长子数组的长度。</p>
//
//<p><strong>注意：子数组</strong> 是数组中的一个连续非空元素序列。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>nums = [3,2,5,4], threshold = 5
//<strong>输出：</strong>3
//<strong>解释：</strong>在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 =&gt; [2,5,4] ，满足上述条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nums = [1,2], threshold = 2
//<strong>输出：</strong>1
//<strong>解释：</strong>
//在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 =&gt; [2] 。
//该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>nums = [2,3,4,5], threshold = 4
//<strong>输出：</strong>3
//<strong>解释：</strong>
//在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 =&gt; [2,3,4] 。 
//该子数组满足上述全部条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 100 </code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 100 </code></li> 
// <li><code>1 &lt;= threshold &lt;= 100</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 29</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-11-16 08:31:28
 */
public class LongestEvenOddSubarrayWithThreshold {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 0, ans = 0;
        for (int num : nums) {
            if (num <= threshold && num % 2 == l % 2) {
                l++;
            } else {
                l = num <= threshold && num % 2 == 0 ? 1: 0;
            }
            ans = Math.max(ans, l);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestEvenOddSubarrayWithThreshold().new Solution();
        System.out.println(solution.longestAlternatingSubarray(
                new int[]{3,2,5,4}, 5
        ));
    }
}