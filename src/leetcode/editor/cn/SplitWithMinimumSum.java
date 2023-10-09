//<p>给你一个正整数&nbsp;<code>num</code>&nbsp;，请你将它分割成两个非负整数&nbsp;<code>num1</code> 和&nbsp;<code>num2</code>&nbsp;，满足：</p>
//
//<ul> 
// <li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;直接连起来，得到&nbsp;<code>num</code>&nbsp;各数位的一个排列。 </li>
//</ul>
//
//    <ul>
//    	<li>换句话说，<code>num1</code> 和&nbsp;<code>num2</code>&nbsp;中所有数字出现的次数之和等于&nbsp;<code>num</code>&nbsp;中所有数字出现的次数。</li>
//    </ul>
//    </li>
//    <li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;可以包含前导 0 。</li>
//
//
//<p>请你返回&nbsp;<code>num1</code> 和 <code>num2</code>&nbsp;可以得到的和的 <strong>最小</strong> 值。</p>
//
//<p><strong>注意：</strong></p>
//
//<ul> 
// <li><code>num</code>&nbsp;保证没有前导 0 。</li> 
// <li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;中数位顺序可以与&nbsp;<code>num</code>&nbsp;中数位顺序不同。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<b>输入：</b>num = 4325
//<b>输出：</b>59
//<b>解释：</b>我们可以将 4325 分割成 <span><code>num1 </code></span>= 24 和 num2<span><code> = </code></span>35 ，和为 59 ，59 是最小和。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<b>输入：</b>num = 687
//<b>输出：</b>75
//<b>解释：</b>我们可以将 687 分割成 <span><code>num1</code></span> = 68 和 <span><code>num2 </code></span>= 7 ，和为最优值 75 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>10 &lt;= num &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数学</li><li>排序</li></div></div><br><div><li>👍 28</li><li>👎 0</li></div>

package leetcode.editor.cn;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wangzhiheng
 * @date 2023-10-09 08:28:33
 */
public class SplitWithMinimumSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitNum(int num) {
            char[] nums = (num + "").toCharArray();
            Arrays.sort(nums);

            int num1 = 0, num2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    num1 = num1 * 10 + (nums[i] - '0');
                } else {
                    num2 = num2 * 10 + (nums[i] - '0');
                }
            }
            return num1 + num2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SplitWithMinimumSum().new Solution();
        System.out.println(solution.splitNum(687));
    }
}