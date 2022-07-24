
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
    boolean hasPathSums = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum);
        return hasPathSums;
    }
    public void pathSum(TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) hasPathSums = true;
            return;
        }
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
    }
}