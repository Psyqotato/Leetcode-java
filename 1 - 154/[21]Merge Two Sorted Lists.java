class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode pin = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pin.next = list2;
                list2 = list2.next;
            }else{
                pin.next = list1;
                list1 = list1.next;
            }
            pin = pin.next;
        }

        if (list1 != null) {
            pin.next = list1;
        }
        if (list2 != null) {
            pin.next = list2;
        }

        return dummy.next;
    }
}