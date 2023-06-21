/**
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 

 candidates 中的每个数字在每个组合中只能使用 一次 。 

 注意：解集不能包含重复的组合。 

 

 示例 1: 

 
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
] 

 示例 2: 

 
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
] 

 

 提示: 

 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 
 

 Related Topics 数组 回溯 👍 1364 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

/**
 * @author wangzhiheng
 */
public class CombinationSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, deque);

        return res;
    }

        public void dfs(int[] candidates, int start, int target, Deque<Integer> deque) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                deque.add(candidates[i]);

                dfs(candidates, i + 1, target - candidates[i], deque);

                deque.removeLast();

            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}