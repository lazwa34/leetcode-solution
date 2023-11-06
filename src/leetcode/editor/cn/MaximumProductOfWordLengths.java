//<p>给你一个字符串数组&nbsp;<code>words</code> ，找出并返回 <code>length(words[i]) * length(words[j])</code>&nbsp;的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 <code>0</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1：</strong></p>
//
//<pre>
//<strong>输入：</strong>words = <span><code>["abcw","baz","foo","bar","xtfn","abcdef"]</code></span>
//<strong>输出：</strong><span><code>16 
//<strong>解释</strong></code></span><strong>：</strong><span><code>这两个单词为<strong> </strong>"abcw", "xtfn"</code></span>。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>words = <span><code>["a","ab","abc","d","cd","bcd","abcd"]</code></span>
//<strong>输出：</strong><span><code>4 
//<strong>解释</strong></code></span><strong>：</strong>这两个单词为 <span><code>"ab", "cd"</code></span>。</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>words = <span><code>["a","aa","aaa","aaaa"]</code></span>
//<strong>输出：</strong><span><code>0 
//<strong>解释</strong></code></span><strong>：</strong><span><code>不存在这样的两个单词。</code></span>
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>2 &lt;= words.length &lt;= 1000</code></li> 
// <li><code>1 &lt;= words[i].length &lt;= 1000</code></li> 
// <li><code>words[i]</code>&nbsp;仅包含小写字母</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>字符串</li></div></div><br><div><li>👍 436</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangzhiheng
 * @date 2023-11-06 08:33:38
 */
public class MaximumProductOfWordLengths {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            Map<String, Set<Character>> map = new HashMap<>();
            int ans = 0;
            for (String word : words) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < word.length(); i++) {
                    set.add(word.charAt(i));
                }
                map.put(word, set);
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    Set<Character> seti = map.get(words[i]);
                    Set<Character> setj = map.get(words[j]);
                    HashSet<Character> temp = new HashSet<>();
                    temp.addAll(seti);
                    temp.addAll(setj);
                    if (seti.size() + setj.size() == temp.size()) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        System.out.println(solution.maxProduct(
                new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}
        ));
    }
}