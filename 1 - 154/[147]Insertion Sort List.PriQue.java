
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        PriorityQueue<ListNode> myPriQueue = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            System.out.println(head);
            myPriQueue.add(head);
            head = head.next;
        }
        ListNode p = dummy;
        while (!myPriQueue.isEmpty()) {
            p.next = myPriQueue.poll();
            p = p.next;
        }
        p.next = null;
        return dummy.next;
    }
}