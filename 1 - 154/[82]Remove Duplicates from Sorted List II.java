
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;

        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                while (fast.next != null && fast.next.val == fast.val) fast = fast.next;
                fast = fast.next;
                if (fast == null) slow.next = null;
            }else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}