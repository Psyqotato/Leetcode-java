class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = new ListNode();
        result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode pin = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
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