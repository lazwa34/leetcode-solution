/**
给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 

 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 

 

 示例 1： 

 

 
输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
输出：13
解释：
所有非零偏移下降路径包括：
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 

 示例 2： 

 
输入：grid = [[7]]
输出：7
 

 

 提示： 

 
 n == grid.length == grid[i].length 
 1 <= n <= 200 
 -99 <= grid[i][j] <= 99 
 

 Related Topics 数组 动态规划 矩阵 👍 108 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wangzhiheng
 * @date 2023-08-10 08:52:13
 */
public class MinimumFallingPathSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                dp[0][i] = grid[0][i];
            }
            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < col; k++) {
                        if (j != k) {
                            dp[i][j] = Math.min(dp[i-1][k] + grid[i][j], dp[i][j]);
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < col; i++) {
                min = Math.min(min, dp[row - 1][i]);
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSumIi().new Solution();
        System.out.println(solution.minFallingPathSum(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        ));
    }
}