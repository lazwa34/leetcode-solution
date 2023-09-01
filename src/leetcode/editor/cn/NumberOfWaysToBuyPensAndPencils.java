//<p>给你一个整数&nbsp;<code>total</code>&nbsp;，表示你拥有的总钱数。同时给你两个整数&nbsp;<code>cost1</code> 和&nbsp;<code>cost2</code>&nbsp;，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。</p>
//
//<p>请你返回购买钢笔和铅笔的&nbsp;<strong>不同方案数目</strong>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><b>输入：</b>total = 20, cost1 = 10, cost2 = 5
//<b>输出：</b>9
//<b>解释：</b>一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
//- 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
//- 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
//- 如果你买 2 支钢笔，那么你没法买任何铅笔。
//所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><b>输入：</b>total = 5, cost1 = 10, cost2 = 10
//<b>输出：</b>1
//<b>解释：</b>钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= total, cost1, cost2 &lt;= 10<sup>6</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li><li>枚举</li></div></div><br><div><li>👍 50</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-01 14:26:44
 */
public class NumberOfWaysToBuyPensAndPencils {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            if (total < cost1 && total < cost2) {
                return 1;
            }
            long res = 0;
            for (int i = 0; i <= total / cost1; i++) {
                res += (total - (long) i * cost1) / cost2 + 1;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToBuyPensAndPencils().new Solution();
        System.out.println(solution.waysToBuyPensPencils(1000000, 1, 1));
    }
}