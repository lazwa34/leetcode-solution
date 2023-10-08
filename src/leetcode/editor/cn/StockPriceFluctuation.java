//<p>给你一支股票价格的数据流。数据流中每一条记录包含一个 <strong>时间戳</strong>&nbsp;和该时间点股票对应的 <strong>价格</strong>&nbsp;。</p>
//
//<p>不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 <b>更正</b>&nbsp;前一条错误的记录。</p>
//
//<p>请你设计一个算法，实现：</p>
//
//<ul> 
// <li><strong>更新 </strong>股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将&nbsp;<strong>更正</strong>&nbsp;之前的错误价格。</li> 
// <li>找到当前记录里 <b>最新股票价格</b>&nbsp;。<strong>最新股票价格</strong>&nbsp;定义为时间戳最晚的股票价格。</li> 
// <li>找到当前记录里股票的 <strong>最高价格</strong>&nbsp;。</li> 
// <li>找到当前记录里股票的 <strong>最低价格</strong>&nbsp;。</li> 
//</ul>
//
//<p>请你实现&nbsp;<code>StockPrice</code>&nbsp;类：</p>
//
//<ul> 
// <li><code>StockPrice()</code>&nbsp;初始化对象，当前无股票价格记录。</li> 
// <li><code>void update(int timestamp, int price)</code>&nbsp;在时间点 <code>timestamp</code>&nbsp;更新股票价格为 <code>price</code>&nbsp;。</li> 
// <li><code>int current()</code>&nbsp;返回股票 <strong>最新价格</strong>&nbsp;。</li> 
// <li><code>int maximum()</code>&nbsp;返回股票 <strong>最高价格</strong>&nbsp;。</li> 
// <li><code>int minimum()</code>&nbsp;返回股票 <strong>最低价格</strong>&nbsp;。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>
//["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
//[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
//<strong>输出：</strong>
//[null, null, null, 5, 10, null, 5, null, 2]
//
//<strong>解释：</strong>
//StockPrice stockPrice = new StockPrice();
//stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
//stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
//stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
//stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
//                          // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
//stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
//stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
//stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= timestamp, price &lt;= 10<sup>9</sup></code></li> 
// <li><code>update</code>，<code>current</code>，<code>maximum</code>&nbsp;和&nbsp;<code>minimum</code>&nbsp;<strong>总</strong> 调用次数不超过&nbsp;<code>10<sup>5</sup></code>&nbsp;。</li> 
// <li><code>current</code>，<code>maximum</code>&nbsp;和&nbsp;<code>minimum</code>&nbsp;被调用时，<code>update</code>&nbsp;操作 <strong>至少</strong>&nbsp;已经被调用过 <strong>一次</strong>&nbsp;。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>数据流</li><li>有序集合</li><li>堆（优先队列）</li></div></div><br><div><li>👍 144</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangzhiheng
 * @date 2023-10-08 08:27:06
 */
public class StockPriceFluctuation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class StockPrice {

        private int lastTime;
        private int lastPrice;
        private final Map<Integer, Integer> hashTime;
        private final TreeMap<Integer, Integer> hashPrice;

        public StockPrice() {
            this.lastPrice = -1;
            this.lastTime = -1;
            this.hashTime =  new HashMap<>();
            this.hashPrice = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if (timestamp >= lastTime) {
                lastPrice = price;
                lastTime = timestamp;
            }
            Integer update = hashTime.getOrDefault(timestamp, null);
            hashTime.put(timestamp, price);
            if (update != null) {
                Integer p = hashPrice.get(update);
                if (p > 1) {
                    hashPrice.put(update, p - 1);
                } else {
                    hashPrice.remove(update);
                }
            }
            update = hashPrice.getOrDefault(price, 0);
            hashPrice.put(price, update + 1);
        }

        public int current() {
            return lastPrice;
        }

        public int maximum() {
            return hashPrice.lastKey();
        }

        public int minimum() {
            return hashPrice.firstKey();
        }
    }

    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPriceFluctuation().new StockPrice();
    }
}