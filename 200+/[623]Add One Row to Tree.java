class Solution {
    int val, depth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        traverse(root);
        return root;
    }
    int curDepth = 1;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        curDepth++;
        if (curDepth == depth) {
            TreeNode newNodeLeft = new TreeNode(val, root.left, null);
            TreeNode newNodeRight = new TreeNode(val, null, root.right);
            root.left = newNodeLeft;
            root.right = newNodeRight;
        }
        traverse(root.left);
        traverse(root.right);
        curDepth--;
    }
}