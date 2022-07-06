class Solution {
    int nthFromEnd = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode temp = p.next;
        if (p.next != null) {
            p.next = removeNthFromEnd(temp, n);
        }
        nthFromEnd++;
        return (nthFromEnd == n) ? temp : p;
    }
}