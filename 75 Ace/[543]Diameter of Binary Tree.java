
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
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(deptTree(root) - 1, result);
    }
    int deptTree(TreeNode root) {
        if (root == null) return 0;
        int left = deptTree(root.left);
        int right = deptTree(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}