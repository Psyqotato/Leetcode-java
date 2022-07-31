class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode l = dummy;
        int up = 0;
        while (l1 != null || l2 != null || up > 0) {
            int val = up;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            up = val / 10;
            val = val % 10;
            l.next = new ListNode(val);
            l = l.next;
        };
        return dummy.next;
    }
}