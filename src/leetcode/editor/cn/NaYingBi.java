//<p>桌上有 <code>n</code> 堆力扣币，每堆的数量保存在数组 <code>coins</code> 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。</p>
//
//<p><strong>示例 1：</strong></p>
//
//<blockquote> 
// <p>输入：<code>[4,2,1]</code></p> 
//</blockquote>
//
//<p>输出：<code>4</code></p>
//
//<p>解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。</p>
//
//<p><strong>示例 2：</strong></p>
//
//<blockquote> 
// <p>输入：<code>[2,3,10]</code></p> 
//</blockquote>
//
//<p>输出：<code>8</code></p>
//
//<p><strong>限制：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 4</code></li> 
// <li><code>1 &lt;= coins[i] &lt;= 10</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 82</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-20 09:31:51
 */
public class NaYingBi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCount(int[] coins) {
            int res = 0;
            for (int coin : coins) {
                res += coin / 2;
                res += coin % 2;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NaYingBi().new Solution();
        System.out.println(solution.minCount(
                new int[]{2, 3, 10}
        ));
    }
}