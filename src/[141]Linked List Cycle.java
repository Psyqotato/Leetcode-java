
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    HashSet<ListNode> visited;
    public boolean hasCycle(ListNode head) {
        visited = new HashSet<ListNode>();
        return traverse(head);
    }
    boolean traverse(ListNode head) {
        if (head == null) return false;
        if (visited.contains(head)) return true;
        visited.add(head);
        return traverse(head.next);
    }
}