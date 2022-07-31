class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;
        ListNode pTemp = head;
        ListNode p = pTemp;
        ListNode dummy = new ListNode();
        ListNode dummyP = dummy;
        while (count < k && head != null && head.next != null) {
            count++;
            p = p.next;
            head = head.next;
            if (count == k) {
                ListNode breakPoint = head.next;
                p.next = null;
                dummyP.next = reverseGroup(pTemp);
                head = breakPoint;
                while (dummyP.next != null) dummyP = dummyP.next;
                pTemp = head;
                p = pTemp;
                count = 1;
            }
        }
        if (count != 0) dummyP.next = pTemp;
        return dummy.next;
    }

    ListNode reverseGroup(ListNode head) {
        ListNode dummy = new ListNode();
        if  (head.next != null) {
            dummy.next = reverseGroup(head.next);
        }
        head.next = null;
        ListNode p = dummy;
        while(p.next != null) {
            p = p.next;
        }
        p.next = head;
        return dummy.next;
    }
}