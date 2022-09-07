
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

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        sb.append(root.val);
        if (!right.equals("")) {
            sb.append("(" + left + ")");
            sb.append("(" + right + ")");
        }else if (!left.equals("")) {
            sb.append("(" + left + ")");
        }
        return sb.toString();
    }
}