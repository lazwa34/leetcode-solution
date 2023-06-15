/**
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 

 

 示例 1： 
 
 
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
 

 示例 2： 

 
输入：head = [1], n = 1
输出：[]
 

 示例 3： 

 
输入：head = [1,2], n = 1
输出：[1]
 

 

 提示： 

 
 链表中结点的数目为 sz 
 1 <= sz <= 30 
 0 <= Node.val <= 100 
 1 <= n <= sz 
 

 

 进阶：你能尝试使用一趟扫描实现吗？ 

 Related Topics 链表 双指针 👍 2561 👎 0

*/

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 */
public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode l = pre, r = pre;
            while (n > 0) {
                r = r.next;
                n--;
            }
            while (r.next != null) {
                l = l.next;
                r = r.next;
            }
            l.next = l.next.next;
            return pre.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
}