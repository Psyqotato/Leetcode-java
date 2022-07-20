
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode reverseP = new ListNode();
        reverseP.next = head;
        ListNode start = reverseP, end = reverseP;
        ListNode bp;
        while (right > 0) {
            if (left > 1) {
                start = start.next;
                left--;
            }
            end = end.next;
            right--;
        }
        bp = end.next;
        end.next = null;
        reverseListNode(start.next).next = bp;
        start.next = dummy.next;
        return reverseP.next;
    }
    ListNode dummy = new ListNode();
    public ListNode reverseListNode(ListNode head) {
        if (head.next == null) {
            dummy.next = head;
            return head;
        }
        ListNode temp = reverseListNode(head.next);
        temp.next = head;
        head.next = null;
        return head;
    }
}