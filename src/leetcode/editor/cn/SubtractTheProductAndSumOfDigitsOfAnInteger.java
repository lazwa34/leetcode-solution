/**
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 

 

 示例 1： 

 输入：n = 234
输出：15 
解释：
各位数之积 = 2 * 3 * 4 = 24 
各位数之和 = 2 + 3 + 4 = 9 
结果 = 24 - 9 = 15
 

 示例 2： 

 输入：n = 4421
输出：21
解释： 
各位数之积 = 4 * 4 * 2 * 1 = 32 
各位数之和 = 4 + 4 + 2 + 1 = 11 
结果 = 32 - 11 = 21
 

 

 提示： 

 
 1 <= n <= 10^5 
 

 Related Topics 数学 👍 136 👎 0

*/

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-08-09 14:46:23
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            if (n == 0) {
                return 0;
            }
            int seq = 1; int add = 0;
            while (n > 0) {
                seq *= n % 10;
                add += n % 10;
                n /= 10;
            }

            return seq - add;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
        System.out.println(solution.subtractProductAndSum(4421));
    }
}