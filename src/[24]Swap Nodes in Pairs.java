class Solution {
    int count = 0;
    int even = 0;
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode temp = head.next;
        even++;
        if (head.next != null) {
            head.next = swapPairs(head.next);
        }
        count++;
        if(count == 1 && even % 2 != 0) {
            even--;
            return head;
        }else if (even % 2 == 0) {
            even--;
            return head.next;
        }else {
            even--;
            temp.next = head;
            return temp;
        }

    }
}