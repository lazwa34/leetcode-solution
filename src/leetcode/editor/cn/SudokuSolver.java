/**
编写一个程序，通过填充空格来解决数独问题。 

 数独的解法需 遵循如下规则： 

 
 数字 1-9 在每一行只能出现一次。 
 数字 1-9 在每一列只能出现一次。 
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
 

 数独部分空格内已填入了数字，空白格用 '.' 表示。 

 

 
 
 
 示例 1： 
 
 
输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",
".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".",
"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".
",".",".",".","8",".",".","7","9"]]
输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4
","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6
","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5
","2","8","6","1","7","9"]]
解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 
 
 
 



 

 提示： 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] 是一位数字或者 '.' 
 题目数据 保证 输入数独仅有一个解 
 

 Related Topics 数组 哈希表 回溯 矩阵 👍 1658 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author wangzhiheng
 */
public class SudokuSolver {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }

        public boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    for (char k = '1'; k <= '9'; k++) {
                        if (check(i, j, k, board)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        public boolean check(int row, int col, char val, char[][] board) {
            // 行
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == val) {
                    return false;
                }
            }
            // 列
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == val) {
                    return false;
                }
            }

            // 9格
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == val){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
    }
}