//<p>在一个&nbsp;<strong>8x8</strong>&nbsp;的棋盘上，放置着若干「黑皇后」和一个「白国王」。</p>
//
//<p>给定一个由整数坐标组成的数组&nbsp;<code>queens</code>&nbsp;，表示黑皇后的位置；以及一对坐标&nbsp;<code>king</code> ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/13/untitled-diagram.jpg" /></p>
//
//<pre>
//<strong>输入：</strong>queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
//<strong>输出：</strong>[[0,1],[1,0],[3,3]]
//<strong>解释：</strong> 
//[0,1] 的皇后可以攻击到国王，因为他们在同一行上。 
//[1,0] 的皇后可以攻击到国王，因为他们在同一列上。 
//[3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。 
//[0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。 
//[4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。 
//[2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/13/untitled-diagram-1.jpg" /></strong></p>
//
//<pre>
//<strong>输入：</strong>queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
//<strong>输出：</strong>[[2,2],[3,4],[4,4]]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/13/untitled-diagram-2.jpg" /></strong></p>
//
//<pre>
//<strong>输入：</strong>queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
//<strong>输出：</strong>[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= queens.length&nbsp;&lt;= 63</code></li> 
// <li><code>queens[i].length == 2</code></li> 
// <li><code>0 &lt;= queens[i][j] &lt;&nbsp;8</code></li> 
// <li><code>king.length == 2</code></li> 
// <li><code>0 &lt;= king[0], king[1] &lt; 8</code></li> 
// <li>一个棋盘格上最多只能放置一枚棋子。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 66</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangzhiheng
 * @date 2023-09-14 08:44:12
 */
public class QueensThatCanAttackTheKing {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> res = new ArrayList<>();

            boolean[][] flag = new boolean[8][8];
            for(int[] queen : queens) {
                flag[queen[0]][queen[1]] = true;
            }

            for (int[] direction : directions) {
                for (int x = king[0], y = king[1]
                        ; x >=0 && x< 8 && y >=0 && y < 8
                        ; x += direction[0], y += direction[1]) {
                    if(flag[x][y]) {
                        res.add(Arrays.asList(x,y));
                        break;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new QueensThatCanAttackTheKing().new Solution();
        System.out.println(solution.queensAttacktheKing(
                new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}},
                new int[]{0,0}
        ));
    }
}