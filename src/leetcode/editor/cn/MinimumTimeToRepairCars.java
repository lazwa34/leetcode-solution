//<p>给你一个整数数组&nbsp;<code>ranks</code>&nbsp;，表示一些机械工的 <strong>能力值</strong>&nbsp;。<code>ranks<sub>i</sub></code> 是第 <code>i</code> 位机械工的能力值。能力值为&nbsp;<code>r</code>&nbsp;的机械工可以在&nbsp;<code>r * n<sup>2</sup></code>&nbsp;分钟内修好&nbsp;<code>n</code>&nbsp;辆车。</p>
//
//<p>同时给你一个整数&nbsp;<code>cars</code>&nbsp;，表示总共需要修理的汽车数目。</p>
//
//<p>请你返回修理所有汽车&nbsp;<strong>最少</strong>&nbsp;需要多少时间。</p>
//
//<p><strong>注意：</strong>所有机械工可以同时修理汽车。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<b>输入：</b>ranks = [4,2,3,1], cars = 10
//<b>输出：</b>16
//<b>解释：</b>
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<b>输入：</b>ranks = [5,1,8], cars = 6
//<b>输出：</b>16
//<b>解释：</b>
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= ranks.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= ranks[i] &lt;= 100</code></li> 
// <li><code>1 &lt;= cars &lt;= 10<sup>6</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 128</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-07 16:16:00
 */
public class MinimumTimeToRepairCars {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            long left = 0, right = (long) ranks[0] * cars * cars;
            while (left < right) {
                long mid = (left + right) >> 1;
                long cnt = 0;
                for (int rank : ranks) {
                    cnt += (long) Math.sqrt(mid / rank);
                }
                if (cnt >= cars) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumTimeToRepairCars().new Solution();
        System.out.println(solution.repairCars(
                new int[] {4,2,3,1}, 10
        ));
    }
}