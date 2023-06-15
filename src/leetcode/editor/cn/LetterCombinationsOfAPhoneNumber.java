/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 

 

 

 示例 1： 

 
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 示例 2： 

 
输入：digits = ""
输出：[]
 

 示例 3： 

 
输入：digits = "2"
输出：["a","b","c"]
 

 

 提示： 

 
 0 <= digits.length <= 4 
 digits[i] 是范围 ['2', '9'] 的一个数字。 
 

 Related Topics 哈希表 字符串 回溯 👍 2493 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhiheng
 */
public class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String letterMap[] = {
                "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv","wxyz"
        };

        public List<String> res;
        public List<String> letterCombinations(String digits) {
            res = new ArrayList<String>();
            if("".equals(digits)) return res;
            combinations(digits, 0, "");
            return res;
        }

        public void combinations(String digits, int index, String s) {
            if (index == digits.length()) {
                res.add(s);
                return;
            }

            char c = digits.charAt(index);
            String letter = letterMap[c - '1'];
            for (int i = 0; i < letter.length(); i++) {
                combinations(digits, index + 1, s + letter.charAt(i));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}