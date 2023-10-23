//<p>给你一个下标从 <strong>0</strong>&nbsp;开始的字符串&nbsp;<code>details</code>&nbsp;。<code>details</code>&nbsp;中每个元素都是一位乘客的信息，信息用长度为 <code>15</code>&nbsp;的字符串表示，表示方式如下：</p>
//
//<ul> 
// <li>前十个字符是乘客的手机号码。</li> 
// <li>接下来的一个字符是乘客的性别。</li> 
// <li>接下来两个字符是乘客的年龄。</li> 
// <li>最后两个字符是乘客的座位号。</li> 
//</ul>
//
//<p>请你返回乘客中年龄 <strong>严格大于 60 岁</strong>&nbsp;的人数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<b>输入：</b>details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
//<b>输出：</b>2
//<b>解释：</b>下标为 0 ，1 和 2 的乘客年龄分别为 75 ，92 和 40 。所以有 2 人年龄大于 60 岁。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<b>输入：</b>details = ["1313579440F2036","2921522980M5644"]
//<b>输出：</b>0
//<b>解释：</b>没有乘客的年龄大于 60 岁。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= details.length &lt;= 100</code></li> 
// <li><code>details[i].length == 15</code></li> 
// <li><code>details[i]</code>&nbsp;中的数字只包含&nbsp;<code>'0'</code>&nbsp;到&nbsp;<code>'9'</code>&nbsp;。</li> 
// <li><code>details[i][10]</code>&nbsp;是 <code>'M'</code>&nbsp;，<code>'F'</code>&nbsp;或者&nbsp;<code>'O'</code>&nbsp;之一。</li> 
// <li>所有乘客的手机号码和座位号互不相同。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-10-23 08:28:24
 */
public class NumberOfSeniorCitizens {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfSeniorCitizens().new Solution();
        System.out.println(solution.countSeniors(
                new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}
        ));
    }
}