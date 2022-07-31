class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode bigger = new ListNode();
        ListNode p = dummy;
        ListNode bp = bigger;

        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
                head = head.next;
            }else {
                bp.next = head;
                bp = bp.next;
                head = head.next;
            }
        }
        bp.next = null;
        p.next = bigger.next;
        return dummy.next;
    }
}