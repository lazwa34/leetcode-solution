/**
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 

 

 示例 1： 

 
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
 

 示例 2： 

 
输入：n = 1
输出：["()"]
 

 

 提示： 

 
 1 <= n <= 8 
 

 Related Topics 字符串 动态规划 回溯 👍 3256 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhiheng
 */
public class GenerateParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            generate("", n, 0, 0);
            return list;
        }

        public void generate(String res, int n, int l, int r) {
            if (l == n && r == n) {
                list.add(res);
                return;
            }
            if (l > n || r > n || r > l) {
                return;
            }
            generate(res + "(", n, l + 1, r);
            generate(res + ")", n, l, r + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}