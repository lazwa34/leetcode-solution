//<p>给你一个大小为 <code>m x n</code> 的矩阵 <code>mat</code> ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg" style="width: 334px; height: 334px;" /> 
//<pre>
//<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>输出：</strong>[1,2,4,7,5,3,6,8,9]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>mat = [[1,2],[3,4]]
//<strong>输出：</strong>[1,2,3,4]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>m == mat.length</code></li> 
// <li><code>n == mat[i].length</code></li> 
// <li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>5</sup> &lt;= mat[i][j] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 463</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 * @date 2023-09-08 16:58:31
 */
public class DiagonalTraverse {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length, cnt = n * m;
            int[] ans = new int[cnt];
            int x = 0, y = 0, idx = 0;
            int tag = 1;
            while (idx != cnt) {
                ans[idx++] = mat[x][y];
                int xx = x, yy = y;
                if (tag == 1) {
                    xx = x - 1; yy = y + 1;
                } else {
                    xx = x + 1; yy = y - 1;
                }
                if (idx < cnt && (xx < 0 || xx >= m || yy < 0 || yy >= n)) {
                    if (tag == 1) {
                        xx = y + 1 < n ? x : x + 1;
                        yy = y + 1 < n ? y + 1 : y;
                    } else {
                        xx = x + 1 < m ? x + 1 : x;
                        yy = x + 1 < m ? y : y + 1;
                    }
                    tag *= -1;
                }
                x = xx; y = yy;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(
                new int[][]{
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                }
        )));
    }
}