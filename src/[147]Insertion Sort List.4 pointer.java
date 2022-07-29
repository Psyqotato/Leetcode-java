
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

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
    public ListNode insertionSortList(ListNode head) {
        ListNode fast, slow, bpfast, bpslow;
        ListNode dummy = new ListNode(-10);
        dummy.next = head;
        slow = dummy;
        fast = head;
        while (fast.next != null) {
            while (fast.next != null && fast.next.val > fast.val) fast = fast.next;
            if (fast.next == null) break;
            while (fast.next.val > slow.next.val) slow = slow.next;
            bpfast = fast.next;
            fast.next = fast.next.next;
            bpslow = slow.next;
            slow.next = bpfast;
            bpfast.next = bpslow;
            slow = dummy;
        }
        return dummy.next;
    }
}