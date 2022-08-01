
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listA = new HashSet<ListNode>();
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            listA.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (listA.contains(p)) return p;
            p = p.next;
        }
        return null;
    }
}