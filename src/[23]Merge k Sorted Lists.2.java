import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = new ListNode();
        ListNode pin = result;
        PriorityQueue<ListNode> listsQueue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if  (head != null) {
                listsQueue.add(head);
            }
        }
        while (!listsQueue.isEmpty()) {
            ListNode temp = listsQueue.poll();
            pin.next = temp;
            if (temp.next != null) {
                listsQueue.add(temp.next);
            }
            pin = pin.next;
        }
        return result.next;
    }
}