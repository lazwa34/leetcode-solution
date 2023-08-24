//<p>You are given a map of a server center, represented as a <code>m * n</code> integer matrix&nbsp;<code>grid</code>, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.<br /> <br /> Return the number of servers&nbsp;that communicate with any other server.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-6.jpg" style="width: 202px; height: 203px;" /></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,0],[0,1]]
//<strong>Output:</strong> 0
//<b>Explanation:</b>&nbsp;No servers can communicate with others.</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/11/13/untitled-diagram-4.jpg" style="width: 203px; height: 203px;" /></strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,0],[1,1]]
//<strong>Output:</strong> 3
//<b>Explanation:</b>&nbsp;All three servers can communicate with at least one other server.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-1-3.jpg" style="width: 443px; height: 443px;" /></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
//<strong>Output:</strong> 4
//<b>Explanation:</b>&nbsp;The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>m == grid.length</code></li> 
// <li><code>n == grid[i].length</code></li> 
// <li><code>1 &lt;= m &lt;= 250</code></li> 
// <li><code>1 &lt;= n &lt;= 250</code></li> 
// <li><code>grid[i][j] == 0 or 1</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>数组</li><li>计数</li><li>矩阵</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-08-24 10:18:41
 */
public class CountServersThatCommunicate {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean check(int[][] grid, int x, int y) {
            boolean res = false;
            for (int i = 0; i < grid.length; i++) {
                if (i != x && grid[i][y] == 1) {
                    res = true;
                }
            }
            for (int i = 0; i < grid[x].length; i++) {
                if (i != y && (grid[x][i] == 1)) {
                    res = true;
                }
            }
            return res;
        }
        public int countServers(int[][] grid) {
            if (grid == null) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1 && check(grid, i, j)) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CountServersThatCommunicate().new Solution();
        System.out.println(solution.countServers(
                new int[][]{
                        {1,0},
                        {0,1},
                }
        ));
    }
}