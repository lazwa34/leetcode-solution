//<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> ，如果满足下述条件，则认为数组 <code>nums</code> 是一个 <strong>美丽数组</strong> ：</p>
//
//<ul> 
// <li><code>nums.length</code> 为偶数</li> 
// <li>对所有满足 <code>i % 2 == 0</code> 的下标 <code>i</code> ，<code>nums[i] != nums[i + 1]</code> 均成立</li> 
//</ul>
//
//<p>注意，空数组同样认为是美丽数组。</p>
//
//<p>你可以从 <code>nums</code> 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 <strong>不变</strong> 。</p>
//
//<p>返回使 <code>nums</code> 变为美丽数组所需删除的 <strong>最少</strong> 元素数目<em>。</em></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>nums = [1,1,2,3,5]
//<strong>输出：</strong>1
//<strong>解释：</strong>可以删除 <span><code>nums[0]</code></span> 或 <span><code>nums[1]</code></span> ，这样得到的 <span><code>nums</code></span> = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 1 个元素。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nums = [1,1,2,2,3,3]
//<strong>输出：</strong>2
//<strong>解释：</strong>可以删除 <span><code>nums[0]</code></span> 和 <span><code>nums[5]</code></span> ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 2 个元素。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>数组</li></div></div><br><div><li>👍 46</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-11-21 08:31:37
 */
public class MinimumDeletionsToMakeArrayBeautiful {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletion(int[] nums) {
            int n = nums.length;
            int ans = 0, size = n;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            for (int i = 1; i <= n - 1; i+=2) {
                while (i <= n - 1 && nums[i] == nums[i - 1]) {
                    ans++;
                    i++;
                    size--;
                }
            }
            return size % 2 == 0 ? ans :ans + 1;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeArrayBeautiful().new Solution();
        System.out.println(solution.minDeletion(
                new int[]{1,1,2,3,5}
        ));
    }
}