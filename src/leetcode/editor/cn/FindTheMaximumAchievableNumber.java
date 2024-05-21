//<p>给你两个整数 <code>num</code> 和 <code>t</code> 。</p>
//
//<p>如果整数 <code>x</code> 可以在执行下述操作不超过 <code>t</code> 次的情况下变为与 <code>num</code> 相等，则称其为 <strong>可达成数字</strong> ：</p>
//
//<ul> 
// <li>每次操作将 <code>x</code> 的值增加或减少 <code>1</code> ，同时可以选择将 <code>num</code> 的值增加或减少 <code>1</code> 。</li> 
//</ul>
//
//<p>返回所有可达成数字中的最大值。可以证明至少存在一个可达成数字。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>num = 4, t = 1
//<strong>输出：</strong>6
//<strong>解释：</strong>最大可达成数字是 x = 6 ，执行下述操作可以使其等于 num ：
//- x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。 
//可以证明不存在大于 6 的可达成数字。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>num = 3, t = 2
//<strong>输出：</strong>7
//<strong>解释：</strong>最大的可达成数字是 x = 7 ，执行下述操作可以使其等于 num ：
//- x 减少 1 ，同时 num 增加 1 。此时，x = 6 且 num = 4 。 
//- x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。 
//可以证明不存在大于 7 的可达成数字。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= num, t&nbsp;&lt;= 50</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 38</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2024-05-21 16:50:36
 */
public class FindTheMaximumAchievableNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int theMaximumAchievableX(int num, int t) {
            return num + 2 * t;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindTheMaximumAchievableNumber().new Solution();
    }
}