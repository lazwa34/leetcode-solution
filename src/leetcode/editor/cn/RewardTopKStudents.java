//<p>给你两个字符串数组&nbsp;<code>positive_feedback</code> 和&nbsp;<code>negative_feedback</code>&nbsp;，分别包含表示正面的和负面的词汇。<strong>不会</strong>&nbsp;有单词同时是正面的和负面的。</p>
//
//<p>一开始，每位学生分数为&nbsp;<code>0</code>&nbsp;。每个正面的单词会给学生的分数 <strong>加&nbsp;</strong><code>3</code>&nbsp;分，每个负面的词会给学生的分数 <strong>减&nbsp;</strong>&nbsp;<code>1</code>&nbsp;分。</p>
//
//<p>给你&nbsp;<code>n</code>&nbsp;个学生的评语，用一个下标从 <strong>0</strong>&nbsp;开始的字符串数组&nbsp;<code>report</code>&nbsp;和一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>student_id</code>&nbsp;表示，其中&nbsp;<code>student_id[i]</code>&nbsp;表示这名学生的 ID ，这名学生的评语是&nbsp;<code>report[i]</code>&nbsp;。每名学生的 ID <strong>互不相同</strong>。</p>
//
//<p>给你一个整数&nbsp;<code>k</code>&nbsp;，请你返回按照得分&nbsp;<strong>从高到低</strong>&nbsp;最顶尖的<em>&nbsp;</em><code>k</code>&nbsp;名学生。如果有多名学生分数相同，ID 越小排名越前。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><b>输入：</b>positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
//<b>输出：</b>[1,2]
//<b>解释：</b>
//两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><b>输入：</b>positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
//<b>输出：</b>[2,1]
//<b>解释：</b>
//- ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
//- ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
//学生 2 分数更高，所以返回 [2,1] 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= positive_feedback.length, negative_feedback.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= positive_feedback[i].length, negative_feedback[j].length &lt;= 100</code></li> 
// <li><code>positive_feedback[i]</code> 和&nbsp;<code>negative_feedback[j]</code>&nbsp;都只包含小写英文字母。</li> 
// <li><code>positive_feedback</code> 和&nbsp;<code>negative_feedback</code>&nbsp;中不会有相同单词。</li> 
// <li><code>n == report.length == student_id.length</code></li> 
// <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
// <li><code>report[i]</code>&nbsp;只包含小写英文字母和空格&nbsp;<code>' '</code>&nbsp;。</li> 
// <li><code>report[i]</code>&nbsp;中连续单词之间有单个空格隔开。</li> 
// <li><code>1 &lt;= report[i].length &lt;= 100</code></li> 
// <li><code>1 &lt;= student_id[i] &lt;= 10<sup>9</sup></code></li> 
// <li><code>student_id[i]</code>&nbsp;的值 <strong>互不相同</strong>&nbsp;。</li> 
// <li><code>1 &lt;= k &lt;= n</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>字符串</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 11</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.*;

/**
 * @author wangzhiheng
 * @date 2023-10-11 08:25:06
 */
public class RewardTopKStudents {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String positive : positive_feedback) {
                map.put(positive, 3);
            }
            for (String negative : negative_feedback) {
                map.put(negative, -1);
            }
            int[] ans = new int[report.length];
            for (int i = 0; i < report.length; i++) {
                for (String word : report[i].split(" ")) {
                    if (map.containsKey(word)) {
                        ans[i] += map.get(word);
                    }
                }
            }
            Integer[] id = new Integer[report.length];
            for (int i = 0; i < report.length; i++) {
                id[i] = i;
            }
            Arrays.sort(id, (a,b) -> ans[a] == ans[b] ? student_id[a] - student_id[b] : ans[b] - ans[a]);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                res.add(student_id[id[i]]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RewardTopKStudents().new Solution();
        System.out.println(solution.topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1, 2}, 2
        ));
    }
}