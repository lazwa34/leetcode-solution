//<p>给定一种规律 <code>pattern</code>&nbsp;和一个字符串&nbsp;<code>s</code>&nbsp;，判断 <code>s</code>&nbsp;是否遵循相同的规律。</p>
//
//<p>这里的&nbsp;<strong>遵循&nbsp;</strong>指完全匹配，例如，&nbsp;<code>pattern</code>&nbsp;里的每个字母和字符串&nbsp;<code>s</code><strong>&nbsp;</strong>中的每个非空单词之间存在着双向连接的对应规律。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例1:</strong></p>
//
//<pre>
//<strong>输入:</strong> pattern = <span><code>"abba"</code></span>, s = <span><code>"dog cat cat dog"</code></span>
//<strong>输出:</strong> true</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong>pattern = <span><code>"abba"</code></span>, s = <span><code>"dog cat cat fish"</code></span>
//<strong>输出:</strong> false</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入:</strong> pattern = <span><code>"aaaa"</code></span>, s = <span><code>"dog cat cat dog"</code></span>
//<strong>输出:</strong> false</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= pattern.length &lt;= 300</code></li> 
// <li><code>pattern</code>&nbsp;只包含小写英文字母</li> 
// <li><code>1 &lt;= s.length &lt;= 3000</code></li> 
// <li><code>s</code>&nbsp;只包含小写英文字母和&nbsp;<code>' '</code></li> 
// <li><code>s</code>&nbsp;<strong>不包含</strong> 任何前导或尾随对空格</li> 
// <li><code>s</code>&nbsp;中每个单词都被 <strong>单个空格 </strong>分隔</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 593</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 * @date 2023-08-24 17:13:47
 */
public class WordPattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (pattern.length() != words.length) {
                return false;
            }

            int[] visit = new int[words.length];
            int[] use = new int[pattern.length()];
            for (int i = 0; i < words.length; i++) {
                if (visit[i] == 0 && use[i] == 0) {
                    String flag = words[i];
                    String convert = String.valueOf(pattern.charAt(i));
                    for (int j = 0; j < words.length; j++) {
                        if (words[j].equals(flag) && visit[j] == 0) {
                            words[j] = convert;
                            visit[j] = 1;
                        }
                    }
                    for (int j = 0; j < pattern.length(); j++) {
                        if (String.valueOf(pattern.charAt(j)).equals(convert)) {
                            use[j] = 1;
                        }
                    }
                }
            }
            return pattern.equals(String.join("", words));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        System.out.println(solution.wordPattern("abc", "b c a"));
    }
}