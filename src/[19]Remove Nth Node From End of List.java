class Solution {
    int nthFromEnd = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next != null) {
            head.next = removeNthFromEnd(head.next, n);
        }
        nthFromEnd++;
        return (nthFromEnd == n) ? head.next : head;
    }
}