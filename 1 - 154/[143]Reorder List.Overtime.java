
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

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
    public void reorderList(ListNode head) {
        HashSet<ListNode> reordered = new HashSet<ListNode>();
        ListNode slow, fast, mid;
        fast = slow = mid = head;
        reordered.add(slow);
        mid = mid.next;
        while (fast.next != null) fast = fast.next;
        while (!reordered.contains(fast)) {
            slow.next = fast;
            reordered.add(fast);
            slow = mid;
            mid = mid.next;
            fast.next = slow;
            reordered.add(slow);
            fast = fast.next.next;
            while (!reordered.contains(fast.next)) fast = fast.next;

        }
        slow.next = null;
    }
}