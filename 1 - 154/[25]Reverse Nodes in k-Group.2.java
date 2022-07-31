class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode front = head, end = head;
        for (int i = 0; i < k; i ++) {
            if (end == null) return head;
            end = end.next;
        }
        ListNode newHead = reverseGroup(front, end);
        front.next = reverseKGroup(end, k);
        return newHead;
    }

    ListNode reverseGroup(ListNode front, ListNode end) {
        ListNode pre, cur, after;
        pre = null; cur = front; after = front;
        while (cur != end) {
            after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }
}