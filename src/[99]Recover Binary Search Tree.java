class Solution {
    TreeNode first = null, second = null;
    TreeNode pre = new TreeNode();
    long preVal = Long.MIN_VALUE;
    public void recoverTree(TreeNode root) {
        inorderTree(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    public void inorderTree(TreeNode root) {
        if (root == null) return;
        inorderTree(root.left);
        if (preVal >= root.val) {
            if (first == null) first = pre;
            second = root;
        }
        pre = root;
        preVal = root.val;
        inorderTree(root.right);
    }
}