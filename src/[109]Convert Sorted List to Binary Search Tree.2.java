class Solution {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        for (ListNode p = head; p != null; p = p.next) count++;
        cur = head;
        return buildTree(0, count - 1);
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode();
        int mid = left + (right - left) / 2;
        root.left = buildTree(left, mid - 1);
        root.val = cur.val;
        cur = cur.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}