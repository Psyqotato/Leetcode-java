import java.util.LinkedList;

class Solution {
    LinkedList<Integer> result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverTree(root);
        return result;
    }
    public void traverTree(TreeNode root) {
        if (root == null) return;
        traverTree(root.left);
        result.add(root.val);
        traverTree(root.right);
    }
}