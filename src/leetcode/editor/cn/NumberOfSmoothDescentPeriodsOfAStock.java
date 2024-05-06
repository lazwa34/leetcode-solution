//<p>给你一个整数数组&nbsp;<code>prices</code>&nbsp;，表示一支股票的历史每日股价，其中&nbsp;<code>prices[i]</code>&nbsp;是这支股票第&nbsp;<code>i</code>&nbsp;天的价格。</p>
//
//<p>一个 <strong>平滑下降的阶段</strong>&nbsp;定义为：对于&nbsp;<strong>连续一天或者多天</strong>&nbsp;，每日股价都比 <strong>前一日股价恰好少 </strong><code>1</code>&nbsp;，这个阶段第一天的股价没有限制。</p>
//
//<p>请你返回 <strong>平滑下降阶段</strong>&nbsp;的数目。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><b>输入：</b>prices = [3,2,1,4]
//<b>输出：</b>7
//<b>解释：</b>总共有 7 个平滑下降阶段：
//[3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
//注意，仅一天按照定义也是平滑下降阶段。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><b>输入：</b>prices = [8,6,7,7]
//<b>输出：</b>4
//<b>解释：</b>总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
//由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><b>输入：</b>prices = [1]
//<b>输出：</b>1
//<b>解释：</b>总共有 1 个平滑下降阶段：[1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 32</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2024-05-06 11:40:48
 */
public class NumberOfSmoothDescentPeriodsOfAStock {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long getDescentPeriods(int[] prices) {
            long[] dp = new long[prices.length];
            dp[0] = 1;
            long ans = 1;
            for (int i = 1; i < prices.length; i++) {
                dp[i] = 1;
                if (prices[i] == prices[i - 1] - 1) {
                    dp[i] += dp[i - 1];
                }
                ans += dp[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfSmoothDescentPeriodsOfAStock().new Solution();
    }
}