class Solution {

    int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = inorder.length - 1;
        return traversalTree(postorder, inorder, postorder[p], 0, p);
    }
    public TreeNode traversalTree(int[] postorder, int[] inorder, int rootVal, int start, int end){
        TreeNode current = new TreeNode();
        current.val = rootVal;
        if (start - end == 1) return current;

        int currentP = -1;
        for (int j = start; j <= end; j++) {
            if (inorder[j] == rootVal) {
                currentP = j;
                break;
            }
        }

        if (currentP < end) {
            p--;
            current.right = traversalTree(postorder, inorder, postorder[p], currentP + 1, end);
        }
        if (currentP > start) {
            p--;
            current.left = traversalTree(postorder, inorder, postorder[p], start, currentP - 1);
        }
        return current;
    }
}