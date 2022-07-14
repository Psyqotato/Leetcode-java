
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 1;
        ListNode dummy = new ListNode(-1);
        ListNode countHead = head;
        dummy.next = head;
        ListNode p = dummy;
        while (countHead.next != null) {
            count++;
            countHead = countHead.next;
        }
        int newK = count - k % count;
        count = 1;
        while (count <= newK){
            p = p.next;
            count++;
        }
        countHead.next = dummy.next;
        dummy.next = p.next;
        p.next = null;
        return dummy.next;
    }
}