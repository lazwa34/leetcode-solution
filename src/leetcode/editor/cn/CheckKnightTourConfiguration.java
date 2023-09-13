//<p>骑士在一张 <code>n x n</code> 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 <strong>左上角</strong> 出发，并且访问棋盘上的每个格子 <strong>恰好一次</strong> 。</p>
//
//<p>给你一个 <code>n x n</code> 的整数矩阵 <code>grid</code> ，由范围 <code>[0, n * n - 1]</code> 内的不同整数组成，其中 <code>grid[row][col]</code> 表示单元格 <code>(row, col)</code> 是骑士访问的第 <code>grid[row][col]</code> 个单元格。骑士的行动是从下标 <strong>0</strong> 开始的。</p>
//
//<p>如果 <code>grid</code> 表示了骑士的有效巡视方案，返回 <code>true</code>；否则返回 <code>false</code>。</p>
//
//<p><strong>注意</strong>，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。<br> <img alt="" src="https://assets.leetcode.com/uploads/2018/10/12/knight.png" style="width: 300px; height: 300px;" /></br></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2022/12/28/yetgriddrawio-5.png" style="width: 251px; height: 251px;"> <pre><strong>输入：</strong>grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
//<strong>输出：</strong>true
//<strong>解释：</strong>grid 如上图所示，可以证明这是一个有效的巡视方案。
//</pre> </img>
//
//<p><strong>示例 2：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2022/12/28/yetgriddrawio-6.png" style="width: 151px; height: 151px;"> <pre><strong>输入：</strong>grid = [[0,3,6],[5,8,1],[2,7,4]]
//<strong>输出：</strong>false
//<strong>解释：</strong>grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
//</pre> </img>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == grid.length == grid[i].length</code></li> 
// <li><code>3 &lt;= n &lt;= 7</code></li> 
// <li><code>0 &lt;= grid[row][col] &lt; n * n</code></li> 
// <li><code>grid</code> 中的所有整数 <strong>互不相同</strong></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 36</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-13 14:02:57
 */
public class CheckKnightTourConfiguration {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            if (grid[0][0] != 0) { return false; }
            int n = grid.length;
            int[][] vis = new int[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vis[grid[i][j]][0] = i;
                    vis[grid[i][j]][1] = j;
                }
            }
            for (int i = 1; i < n * n; i++) {
                int dx = Math.abs(vis[i][0] - vis[i - 1][0]);
                int dy = Math.abs(vis[i][1] - vis[i - 1][1]);
                if (dx * dy != 2) {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CheckKnightTourConfiguration().new Solution();
        System.out.println(solution.checkValidGrid(
                new int[][] {
                        {0, 11, 16, 5, 20},
                        {17, 4, 19, 10, 15},
                        {12, 1, 8, 21, 6},
                        {3, 18, 23, 14, 9},
                        {24, 13, 2, 7, 22}
                }
        ));
    }
}