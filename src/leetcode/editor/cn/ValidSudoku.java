/**
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 

 
 数字 1-9 在每一行只能出现一次。 
 数字 1-9 在每一列只能出现一次。 
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
 

 

 注意： 

 
 一个有效的数独（部分已被填充）不一定是可解的。 
 只需要根据以上规则，验证已经填入的数字是否有效即可。 
 空白格用 '.' 表示。 
 

 

 示例 1： 
 
 
输入：board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
 

 示例 2： 

 
输入：board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的
。 

 

 提示： 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] 是一位数字（1-9）或者 '.' 
 

 Related Topics 数组 哈希表 矩阵 👍 1109 👎 0

*/

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 */
public class ValidSudoku {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean valid(char[][] board, int l, int r, int u, int d) {
            boolean res = true;
            int[] verify = new int[10];
            for (int i = u; i < d; i++) {
                for (int j = l; j < r; j++) {
                    if (board[i][j] != '.') {
                        verify[board[i][j] - '0']++;
                        if (verify[board[i][j] - '0'] > 1) {
                            res = false;
                            break;
                        }
                    }
                }
            }
            return res;
        }
        public boolean isValidSudoku(char[][] board) {
            boolean res = true;
            int[] verify;
            for (int i = 0; i < board.length; i++) {
                // 竖
                verify = new int[10];
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] != '.') {
                        verify[board[j][i] - '0']++;
                        if (verify[board[j][i] - '0'] > 1) {
                            res = false;
                            break;
                        }
                    }
                }

                // 横
                verify = new int[10];
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != '.') {
                        verify[board[i][j] - '0']++;
                        if (verify[board[i][j] - '0'] > 1) {
                            res = false;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < board.length; i+=3) {
                for (int j = 0; j < board.length; j+=3) {
                    if (!valid(board, j, j+3, i, i+3)) {
                        res = false;
                        break;
                    }
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();

        char[][] q = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solution.isValidSudoku(q));
    }
}