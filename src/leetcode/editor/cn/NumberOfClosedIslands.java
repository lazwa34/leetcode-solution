/**
二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 

 请返回 封闭岛屿 的数目。 

 

 示例 1： 

 

 
输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,
1],[1,1,1,1,1,1,1,0]]
输出：2
解释：
灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 

 示例 2： 

 

 
输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
输出：1
 

 示例 3： 

 
输入：grid = [[1,1,1,1,1,1,1],
             [1,0,0,0,0,0,1],
             [1,0,1,1,1,0,1],
             [1,0,1,0,1,0,1],
             [1,0,1,1,1,0,1],
             [1,0,0,0,0,0,1],
             [1,1,1,1,1,1,1]]
输出：2
 

 

 提示： 

 
 1 <= grid.length, grid[0].length <= 100 
 0 <= grid[i][j] <=1 
 

 Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 244 👎 0

*/

package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author wangzhiheng
 */
public class NumberOfClosedIslands {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        class Location {
            int x;
            int y;
            public Location(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public int closedIsland(int[][] grid) {
            if (grid == null || grid.length < 3) {
                return 0;
            }
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        res += bfs(grid, i, j);
                    }
                }
            }
            return res;
        }
        public int bfs(int[][] grid, int x, int y) {
            int isClosed = 1;
            LinkedList<Location> queue = new LinkedList<>();
            queue.add(new Location(x, y));
            while (!queue.isEmpty()) {
                Location poll = queue.poll();
                grid[poll.x][poll.y] = 1;
                if (poll.x == 0 || poll.x == grid.length - 1 ||
                    poll.y == 0 || poll.y == grid[0].length - 1) {
                    isClosed = 0;
                }
                for (int[] direction : directions) {
                    int xx = poll.x + direction[0];
                    int yy = poll.y + direction[1];

                    if (xx >= 0 && xx < grid.length &&
                        yy >= 0 && yy < grid[0].length && grid[xx][yy] == 0) {
                        queue.add(new Location(xx, yy));
                    }
                }
            }
            return isClosed;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
        System.out.println(solution.closedIsland(new int[][]{{1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}}));
    }
}