
//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    boolean pFlag = false;
    boolean qFlag = false;
    Stack<TreeNode> pStack = new Stack<TreeNode>();
    Stack<TreeNode> qStack = new Stack<TreeNode>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        while (pStack.size() > qStack.size()) pStack.pop();
        while (qStack.size() > pStack.size()) qStack.pop();
        while (pStack.peek() != qStack.peek()) {
            pStack.pop();
            qStack.pop();
        }
        return pStack.peek();
    }
    public void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (pFlag && qFlag) return;

        if (!pFlag) pStack.push(root);
        if (!qFlag) qStack.push(root);

        if (root == p) pFlag = true;
        if (root == q) qFlag = true;

        if (root.left != null) {
            traverse(root.left, p, q);
            if (!pFlag) pStack.pop();
            if (!qFlag) qStack.pop();
        }
        if (root.right != null) {
            traverse(root.right, p, q);
            if (!pFlag) pStack.pop();
            if (!qFlag) qStack.pop();
        }
    }
}