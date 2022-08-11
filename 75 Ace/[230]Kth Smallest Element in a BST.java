
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
    int result = -1, count = 0;
    public int kthSmallest(TreeNode root, int k) {
        travesalTree(root, k);
        return result;
    }
    void travesalTree(TreeNode root, int k) {
        if (root == null || result != -1) return;
        travesalTree(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        travesalTree(root.right, k);
    }
}