
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return reverseTree(root);
    }
    TreeNode reverseTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = new TreeNode();
        temp = reverseTree(root.left);
        root.left = reverseTree(root.right);
        root.right = temp;
        return root;
    }
}