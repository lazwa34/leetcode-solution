//<p>矩形蛋糕的高度为 <code>h</code> 且宽度为 <code>w</code>，给你两个整数数组 <code>horizontalCuts</code> 和 <code>verticalCuts</code>，其中：</p>
//
//<ul> 
// <li>&nbsp;<code>horizontalCuts[i]</code> 是从矩形蛋糕顶部到第&nbsp; <code>i</code> 个水平切口的距离</li> 
// <li><code>verticalCuts[j]</code> 是从矩形蛋糕的左侧到第 <code>j</code> 个竖直切口的距离</li> 
//</ul>
//
//<p>请你按数组 <em><code>horizontalCuts</code> </em>和<em> <code>verticalCuts</code> </em>中提供的水平和竖直位置切割后，请你找出 <strong>面积最大</strong> 的那份蛋糕，并返回其 <strong>面积</strong> 。由于答案可能是一个很大的数字，因此需要将结果&nbsp;<strong>对</strong>&nbsp;<code>10<sup>9</sup>&nbsp;+ 7</code>&nbsp;<strong>取余</strong> 后返回。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/leetcode_max_area_2.png" /></p>
//
//<pre>
//<strong>输入：</strong>h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//<strong>输出：</strong>4 
//<strong>解释：</strong>上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/leetcode_max_area_3.png" /></strong></p>
//
//<pre>
//<strong>输入：</strong>h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
//<strong>输出：</strong>6
//<strong>解释：</strong>上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
//<strong>输出：</strong>9
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>2 &lt;= h, w &lt;= 10<sup>9</sup></code></li> 
// <li><code>1 &lt;= horizontalCuts.length &lt;= min(h - 1, 10<sup>5</sup>)</code></li> 
// <li><code>1 &lt;= verticalCuts.length &lt;= min(w - 1, 10<sup>5</sup>)</code></li> 
// <li><code>1 &lt;= horizontalCuts[i] &lt; h</code></li> 
// <li><code>1 &lt;= verticalCuts[i] &lt; w</code></li> 
// <li>题目数据保证 <code>horizontalCuts</code> 中的所有元素各不相同</li> 
// <li>题目数据保证 <code>verticalCuts</code>&nbsp;中的所有元素各不相同</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>排序</li></div></div><br><div><li>👍 52</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 * @date 2023-10-27 08:35:50
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            long maxH = 0, maxW = 0;
            int mod = 1000000007;
            for (int i = 1; i < horizontalCuts.length; i++) {
                maxH = Math.max(horizontalCuts[i] - horizontalCuts[i-1], maxH);
            }
            maxH = Math.max(horizontalCuts[0], maxH);
            maxH = Math.max(h - horizontalCuts[horizontalCuts.length - 1], maxH);

            for (int i = 1; i < verticalCuts.length; i++) {
                maxW = Math.max(verticalCuts[i] - verticalCuts[i-1], maxW);
            }
            maxW = Math.max(verticalCuts[0], maxW);
            maxW = Math.max(w - verticalCuts[verticalCuts.length - 1], maxW);

            return (int) ((maxH * maxW) % mod);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts().new Solution();
        System.out.println(solution.maxArea(
                5, 4, new int[]{3,1}, new int[]{1}
        ));
    }
}