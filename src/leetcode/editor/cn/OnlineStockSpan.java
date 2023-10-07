//<p>设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 <strong>跨度</strong> 。</p>
//
//<p>当日股票价格的 <strong>跨度</strong> 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。</p>
//
//<ul> 
// <li> <p>例如，如果未来 7 天股票的价格是 <code>[100,80,60,70,60,75,85]</code>，那么股票跨度将是 <code>[1,1,1,2,1,4,6]</code> 。</p> </li> 
//</ul>
//
//<p>实现 <code>StockSpanner</code> 类：</p>
//
//<ul> 
// <li><code>StockSpanner()</code> 初始化类对象。</li> 
// <li><code>int next(int price)</code> 给出今天的股价 <code>price</code> ，返回该股票当日价格的 <strong>跨度</strong> 。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例：</strong></p>
//
//<pre>
//<strong>输入</strong>：
//["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
//[[], [100], [80], [60], [70], [60], [75], [85]]
//<strong>输出</strong>：
//[null, 1, 1, 1, 2, 1, 4, 6]
//
//<strong>解释：</strong>
//StockSpanner stockSpanner = new StockSpanner();
//stockSpanner.next(100); // 返回 1
//stockSpanner.next(80);  // 返回 1
//stockSpanner.next(60);  // 返回 1
//stockSpanner.next(70);  // 返回 2
//stockSpanner.next(60);  // 返回 1
//stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
//stockSpanner.next(85);  // 返回 6
//</pre>
//
//&nbsp;
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= price &lt;= 10<sup>5</sup></code></li> 
// <li>最多调用 <code>next</code> 方法 <code>10<sup>4</sup></code> 次</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>数据流</li><li>单调栈</li></div></div><br><div><li>👍 359</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author wangzhiheng
 * @date 2023-10-07 08:25:04
 */
public class OnlineStockSpan {
    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {

        private Stack<Integer> prices, widths;
        public StockSpanner() {
            this.prices = new Stack<>();
            this.widths = new Stack<>();
        }

        public int next(int price) {
            int width = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                width += widths.pop();
            }
            prices.push(price);
            widths.push(width);
            return width;
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        StockSpanner stockSpanner = new OnlineStockSpan().new StockSpanner();

    }
}