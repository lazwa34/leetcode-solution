//<p>给你一个由 <strong>不同</strong> 正整数组成的数组 <code>nums</code> ，请你返回满足&nbsp;<code>a * b = c * d</code> 的元组<em> </em><code>(a, b, c, d)</code><em> </em>的数量。其中 <code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> 都是 <code>nums</code> 中的元素，且 <code>a != b != c != d</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,3,4,6]
//<strong>输出：</strong>8
//<strong>解释：</strong>存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,2,4,5,10]
//<strong>输出：</strong>16
//<strong>解释：</strong>存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 1000</code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 37</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhiheng
 * @date 2023-10-19 08:21:49
 */
public class TupleWithSameProduct {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                int value = map.getOrDefault(key, 0);
                map.put(key, value + 1);
                cnt += value;
            }
        }
        return cnt * 8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TupleWithSameProduct().new Solution();
        System.out.println(solution.tupleSameProduct(
                new int[]{1,2,4,5,10}
        ));
    }
}