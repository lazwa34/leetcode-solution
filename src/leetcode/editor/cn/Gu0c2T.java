//<p>一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong>。</p>
//
//<p>给定一个代表每个房屋存放金额的非负整数数组 <code>nums</code>&nbsp;，请计算<strong>&nbsp;不触动警报装置的情况下 </strong>，一夜之内能够偷窃到的最高金额。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums =<strong> </strong>[1,2,3,1]
//<strong>输出：</strong>4
//<strong>解释：</strong>偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums =<strong> </strong>[2,7,9,3,1]
//<strong>输出：</strong>12
//<strong>解释：</strong>偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//&nbsp;    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 100</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 400</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p>
// <meta charset="UTF-8" />注意：本题与主站 198&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/house-robber/">https://leetcode-cn.com/problems/house-robber/</a></p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 44</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-18 08:28:07
 */
public class Gu0c2T {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
            return dp[nums.length - 1];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Gu0c2T().new Solution();
        System.out.println(solution.rob(
                new int[]{2,9,9,3,1}
        ));
    }
}