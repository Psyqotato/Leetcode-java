
//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;
import java.util.Stack;

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
class BSTIterator {

    Stack<TreeNode> myStack = new Stack<TreeNode>();

    void pushLeftBranch(TreeNode root) {
        while (root != null) {
            myStack.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode temp = myStack.pop();
        pushLeftBranch(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !myStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)