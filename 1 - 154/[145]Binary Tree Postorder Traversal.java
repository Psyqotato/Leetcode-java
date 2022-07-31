import java.util.LinkedList;

class Solution {
    List<Integer> result = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }
    void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        traversal(root.right);
        result.add(root.val);
    }
}