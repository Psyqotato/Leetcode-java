public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}