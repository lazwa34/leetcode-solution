//<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和一个整数 <code>k</code> 。你的 <strong>起始分数</strong> 为 <code>0</code> 。</p>
//
//<p>在一步 <strong>操作</strong> 中：</p>
//
//<ol> 
// <li>选出一个满足 <code>0 &lt;= i &lt; nums.length</code> 的下标 <code>i</code> ，</li> 
// <li>将你的 <strong>分数</strong> 增加 <code>nums[i]</code> ，并且</li> 
// <li>将 <code>nums[i]</code> 替换为 <code>ceil(nums[i] / 3)</code> 。</li> 
//</ol>
//
//<p>返回在 <strong>恰好</strong> 执行 <code>k</code> 次操作后，你可能获得的最大分数。</p>
//
//<p>向上取整函数 <code>ceil(val)</code> 的结果是大于或等于 <code>val</code> 的最小整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [10,10,10,10,10], k = 5
//<strong>输出：</strong>50
//<strong>解释：</strong>对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,10,3,3,3], k = 3
//<strong>输出：</strong>17
//<strong>解释：</strong>可以执行下述操作：
//第 1 步操作：选中 i = 1 ，nums 变为 [1,<em><strong>4</strong></em>,3,3,3] 。分数增加 10 。
//第 2 步操作：选中 i = 1 ，nums 变为 [1,<em><strong>2</strong></em>,3,3,3] 。分数增加 4 。
//第 3 步操作：选中 i = 2 ，nums 变为 [1,1,<em><strong>1</strong></em>,3,3] 。分数增加 3 。
//最后分数是 10 + 4 + 3 = 17 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length, k &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>堆（优先队列）</li></div></div><br><div><li>👍 16</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author wangzhiheng
 * @date 2023-10-18 08:20:09
 */
public class MaximalScoreAfterApplyingKOperations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxKelements(int[] nums, int k) {
            // 大根堆
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int num : nums) {
                queue.offer(num);
            }
            long ans = 0;
            for (int i = 0; i < k; ++i) {
                int x = queue.poll();
                ans += x;
                queue.offer((x + 2) / 3);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaximalScoreAfterApplyingKOperations().new Solution();
        System.out.println(solution.maxKelements(
                new int[]{1,10,3,3,3}, 3
        ));
    }
}