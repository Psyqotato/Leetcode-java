
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;

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
        Deque<ListNode> nodes = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }
        p = head;
        while (!nodes.isEmpty()) {
            p.next = nodes.pollFirst();
            p = p.next;
            if (!nodes.isEmpty()) {
                p.next = nodes.pollLast();
                p = p.next;
            }
        }
        p.next = null;
    }
}