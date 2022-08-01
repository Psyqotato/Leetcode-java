
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            int n = myQueue.size();
            for (int i = n - 1; i >= 0; i--) {
                TreeNode p = myQueue.poll();
                if (p.right != null) myQueue.add(p.right);
                if (p.left != null) myQueue.add(p.left);
                if (i == n - 1) {
                    result.add(p.val);
                }
            }
        }
        return result;
    }
}