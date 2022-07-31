
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

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
    List<Integer> result = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }
    void traversal(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}