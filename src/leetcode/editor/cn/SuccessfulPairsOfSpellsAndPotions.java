//<p>给你两个正整数数组&nbsp;<code>spells</code> 和&nbsp;<code>potions</code>&nbsp;，长度分别为&nbsp;<code>n</code> 和&nbsp;<code>m</code>&nbsp;，其中&nbsp;<code>spells[i]</code>&nbsp;表示第&nbsp;<code>i</code>&nbsp;个咒语的能量强度，<code>potions[j]</code>&nbsp;表示第&nbsp;<code>j</code>&nbsp;瓶药水的能量强度。</p>
//
//<p>同时给你一个整数&nbsp;<code>success</code>&nbsp;。一个咒语和药水的能量强度 <strong>相乘</strong> 如果&nbsp;<strong>大于等于</strong>&nbsp;<code>success</code>&nbsp;，那么它们视为一对&nbsp;<strong>成功</strong>&nbsp;的组合。</p>
//
//<p>请你返回一个长度为 <code>n</code>&nbsp;的整数数组<em>&nbsp;</em><code>pairs</code>，其中<em>&nbsp;</em><code>pairs[i]</code>&nbsp;是能跟第 <code>i</code>&nbsp;个咒语成功组合的 <b>药水</b>&nbsp;数目。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><b>输入：</b>spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//<b>输出：</b>[4,0,3]
//<strong>解释：</strong>
//- 第 0 个咒语：5 * [1,2,3,4,5] = [5,<em><strong>10</strong></em>,<em><strong>15</strong></em>,<em><strong>20</strong></em>,<em><strong>25</strong></em>] 。总共 4 个成功组合。
//- 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
//- 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,<em><strong>9</strong></em>,<em><strong>12</strong></em>,<em><strong>15</strong></em>] 。总共 3 个成功组合。
//所以返回 [4,0,3] 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><b>输入：</b>spells = [3,1,2], potions = [8,5,8], success = 16
//<b>输出：</b>[2,0,2]
//<strong>解释：</strong>
//- 第 0 个咒语：3 * [8,5,8] = [<em><strong>24</strong></em>,15,<em><strong>24</strong></em>] 。总共 2 个成功组合。
//- 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
//- 第 2 个咒语：2 * [8,5,8] = [<em><strong>16</strong></em>,10,<em><strong>16</strong></em>] 。总共 2 个成功组合。
//所以返回 [2,0,2] 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == spells.length</code></li> 
// <li><code>m == potions.length</code></li> 
// <li><code>1 &lt;= n, m &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= spells[i], potions[i] &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= success &lt;= 10<sup>10</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 41</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 * @date 2023-11-10 08:37:33
 */
public class SuccessfulPairsOfSpellsAndPotions {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int[] ans = new int[spells.length];
            Arrays.sort(potions);
            for (int i = 0; i < spells.length; i++) {
                int l = 0, r = potions.length - 1;
                while (l >=0 && r <= potions.length - 1 && l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) spells[i] * potions[mid] < success) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                ans[i] = potions.length - l;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SuccessfulPairsOfSpellsAndPotions().new Solution();
        System.out.println(Arrays.toString(solution.successfulPairs(
                new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7
        )));
    }
}