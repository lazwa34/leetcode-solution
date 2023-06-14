/**
给你一个字符串 s，找到 s 中最长的回文子串。 

 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 

 

 示例 1： 

 
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
 

 示例 2： 

 
输入：s = "cbbd"
输出："bb"
 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 仅由数字和英文字母组成 
 

 Related Topics 字符串 动态规划 👍 6573 👎 0

*/

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 */
public class LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int l, r, max = 0;
        int left = 0, right = 0;

        public void check(int l, int r, char[] array) {
            while (array[l] == array[r]) {
                if (l == 0 || r == array.length - 1) {
                    break;
                }
                l--; r++;
            }
            if (array[l] != array[r]) {
                l++; r--;
            }
            left = max > (r - l) ? left : l;
            right = max > (r - l) ? right : r;
            max = Math.max(max, r - l);
        }
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            char[] array = s.toCharArray();

            for (int i = 0; i < array.length-1; i++) {
                l = i; r = i;
                check(l, r, array);
            }
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] == array[i+1]) {
                    l = i; r = i + 1;
                    check(l, r, array);
                }
            }
//            System.out.println(left + " " +right);
//            System.out.println(s.substring(left, right + 1));
            return s.substring(left, right + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("aaaa");
    }
}