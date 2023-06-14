/**
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 

 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
假设环境不允许存储 64 位整数（有符号或无符号）。

 

 示例 1： 

 
输入：x = 123
输出：321
 

 示例 2： 

 
输入：x = -123
输出：-321
 

 示例 3： 

 
输入：x = 120
输出：21
 

 示例 4： 

 
输入：x = 0
输出：0
 

 

 提示： 

 
 -2³¹ <= x <= 2³¹ - 1 
 

 Related Topics 数学 👍 3845 👎 0

*/

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 */
public class ReverseInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int res = 0, temp;
            while (x != 0) {
                temp = x% 10;
                if (res > Integer.MAX_VALUE / 10
                        || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return 0;
                }
                if (res < Integer.MIN_VALUE / 10
                        || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                    return 0;
                }
                res = res * 10 + temp;
                x /= 10;
            }
//            System.out.println(res);
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        solution.reverse(-214748364);
    }
}