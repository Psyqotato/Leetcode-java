class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public int findTheWinner(int n, int k) {
        if (k == 1) return n;
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 2; i <= n; i++) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        pre.next = head;
        int count = 1;
        while (head.next != head) {
            if (count < k - 1) {
                head = head.next;
                count++;
            }else{
                head.next = head.next.next;
                head = head.next;
                count = 1;
            }
        }
        return head.val;
    }
}