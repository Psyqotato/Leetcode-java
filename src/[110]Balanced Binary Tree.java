
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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDept(root);
        return isBalanced;
    }
    public int maxDept(TreeNode root) {
        if (root == null) return 0;
        int leftDept = maxDept(root.left);
        int rightDept = maxDept(root.right);
        if (Math.abs(leftDept - rightDept) > 1) isBalanced = false;
        return Math.max(leftDept, rightDept) + 1;
    }
}