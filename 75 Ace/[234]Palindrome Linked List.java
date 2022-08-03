class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> myDeque = new LinkedList<ListNode>();
        ListNode p = head;
        while(p != null) {
            myDeque.add(p);
            p = p.next;
        }
        while(myDeque.size() > 1) {
            if (myDeque.peekFirst().val != myDeque.peekLast().val) return false;
            myDeque.pollLast();
            myDeque.pollFirst();
        }
        return true;
    }
}