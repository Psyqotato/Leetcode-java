
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
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> solution = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backTrackPath(root, targetSum);
        return result;
    }
    public void backTrackPath(TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == root.right && root.val == targetSum) {
            solution.add(root.val);
            result.add(new ArrayList<>(solution));
            solution.removeLast();
            return;
        }
        solution.add(root.val);
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        solution.removeLast();
    }
}