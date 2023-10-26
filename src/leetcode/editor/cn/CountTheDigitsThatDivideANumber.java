//<p>给你一个整数 <code>num</code> ，返回 <code>num</code> 中能整除 <code>num</code> 的数位的数目。</p>
//
//<p>如果满足&nbsp;<code>nums % val == 0</code> ，则认为整数 <code>val</code> 可以整除 <code>nums</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>num = 7
//<strong>输出：</strong>1
//<strong>解释：</strong>7 被自己整除，因此答案是 1 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>num = 121
//<strong>输出：</strong>2
//<strong>解释：</strong>121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>num = 1248
//<strong>输出：</strong>4
//<strong>解释：</strong>1248 可以被它每一位上的数字整除，因此答案是 4 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= num &lt;= 10<sup>9</sup></code></li> 
// <li><code>num</code> 的数位中不含 <code>0</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 12</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-10-26 08:38:36
 */
public class CountTheDigitsThatDivideANumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigits(int num) {
            int mod = num, ans = 0;
            while (mod != 0) {
                if (num % (mod % 10) == 0) {
                    ans++;
                }
                mod /= 10;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CountTheDigitsThatDivideANumber().new Solution();
        System.out.println(solution.countDigits(1248));
    }
}