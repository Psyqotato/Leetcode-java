class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast, slow, bp;
        fast = slow = dummy;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != null && fast.next != null) {
            bp = slow.next;
            slow.next = fast.next;
            fast.next = slow.next.next;
            slow.next.next = bp;
            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }
}