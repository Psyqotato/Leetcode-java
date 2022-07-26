
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    int result = 0;
    int count = 0;
    public int sumNumbers(TreeNode root) {
        traverTree(root);
        return result;
    }
    void traverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        count = count * 10 + root.val;
        if (root.left == root.right) result += count;
        traverTree(root.left);
        traverTree(root.right);
        count = count - root.val;
        count = count / 10;
    }
}