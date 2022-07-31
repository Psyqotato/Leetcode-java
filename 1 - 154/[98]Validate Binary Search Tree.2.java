class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }


    public boolean isValid(TreeNode root) {
        if (root == null) return true;
        if (!isValid(root.left)) return false;
        if (pre.val > root.val) return false;
        pre = root;
        if (!isValid(root.right)) return false;
        return true;
    }
}