import java.util.Stack;

class Solution {
    Stack<Integer> myTreeStacky = new Stack<>();
    int p = 0, i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode current = new TreeNode();
        return traversalTree(current, preorder, inorder);
    }
    public TreeNode traversalTree(TreeNode root, int[] preorder, int[] inorder){
        if (p >= preorder.length) return null;
        TreeNode current = new TreeNode();

        if ((!myTreeStacky.isEmpty() && myTreeStacky.peek() != inorder[i]) || (p < preorder.length)) {
            myTreeStacky.push(preorder[p]);
            p++;
        }
        if (myTreeStacky.peek() != inorder[i]) {
            current.left = traversalTree(current, preorder, inorder);
        }
        if (!myTreeStacky.isEmpty() && myTreeStacky.peek() == inorder[i]) {
            current.val = myTreeStacky.pop();
            i++;
        }
        boolean flag = false;
        for (int j = p; j < preorder.length;j++) {
            if (inorder[i] == preorder[j]) flag = true;
        }
        if (p < preorder.length && flag == true){
            current.right = traversalTree(current, preorder, inorder);
        }
        return current;
    }
}