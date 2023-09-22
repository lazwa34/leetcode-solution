//<p>给你一个整数&nbsp;<code>money</code>&nbsp;，表示你总共有的钱数（单位为美元）和另一个整数&nbsp;<code>children</code>&nbsp;，表示你要将钱分配给多少个儿童。</p>
//
//<p>你需要按照如下规则分配：</p>
//
//<ul> 
// <li>所有的钱都必须被分配。</li> 
// <li>每个儿童至少获得&nbsp;<code>1</code>&nbsp;美元。</li> 
// <li>没有人获得 <code>4</code>&nbsp;美元。</li> 
//</ul>
//
//<p>请你按照上述规则分配金钱，并返回 <strong>最多</strong>&nbsp;有多少个儿童获得 <strong>恰好</strong><em>&nbsp;</em><code>8</code>&nbsp;美元。如果没有任何分配方案，返回&nbsp;<code>-1</code>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><b>输入：</b>money = 20, children = 3
//<b>输出：</b>1
//<b>解释：</b>
//最多获得 8 美元的儿童数为 1 。一种分配方案为：
//- 给第一个儿童分配 8 美元。
//- 给第二个儿童分配 9 美元。
//- 给第三个儿童分配 3 美元。
//没有分配方案能让获得 8 美元的儿童数超过 1 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><b>输入：</b>money = 16, children = 2
//<b>输出：</b>2
//<b>解释：</b>每个儿童都可以获得 8 美元。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= money &lt;= 200</code></li> 
// <li><code>2 &lt;= children &lt;= 30</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数学</li></div></div><br><div><li>👍 39</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-22 08:36:39
 */
public class DistributeMoneyToMaximumChildren {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distMoney(int money, int children) {
            if((money == 4 && children == 1) || money < children){
                return -1;
            }
            money -= children;
            int cnt = Math.min(children, money / 7);
            if ((children == cnt && (money % 7 != 0 || money / 7 > children))
                    || (children == cnt + 1 && money % 7 == 3)) {
                cnt -= 1;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new DistributeMoneyToMaximumChildren().new Solution();
        System.out.println(solution.distMoney(23, 2));
    }
}