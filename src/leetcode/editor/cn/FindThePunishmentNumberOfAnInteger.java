//<p>给你一个正整数&nbsp;<code>n</code>&nbsp;，请你返回&nbsp;<code>n</code>&nbsp;的&nbsp;<strong>惩罚数</strong>&nbsp;。</p>
//
//<p><code>n</code>&nbsp;的 <strong>惩罚数</strong>&nbsp;定义为所有满足以下条件 <code>i</code>&nbsp;的数的平方和：</p>
//
//<ul> 
// <li><code>1 &lt;= i &lt;= n</code></li> 
// <li><code>i * i</code> 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 <code>i</code> 。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<b>输入：</b>n = 10
//<b>输出：</b>182
//<b>解释：</b>总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<b>输入：</b>n = 37
//<b>输出：</b>1478
//<b>解释：</b>总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li><li>回溯</li></div></div><br><div><li>👍 39</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-10-25 08:32:50
 */
public class FindThePunishmentNumberOfAnInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toString(i * i);
            if (dfs(str, 0, 0, i)) {
                res += i * i;
            }
        }
        return res;
    }

    public boolean dfs(String str, int pos, int tot, int target) {
        if (pos == str.length()) {
            return tot == target;
        }
        int sum = 0;
        for (int i = pos; i < str.length(); i++) {
            sum = sum * 10 + str.charAt(i) - '0';
            if (sum + tot > target) {
                break;
            }
            if (dfs(str, i + 1, tot + sum, target)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindThePunishmentNumberOfAnInteger().new Solution();
        System.out.println(solution.punishmentNumber(10));
    }
}