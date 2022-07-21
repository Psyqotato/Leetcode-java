
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);
        while(!myQueue.isEmpty()) {
            int n = myQueue.size();
            List<Integer> level = new LinkedList<>();
            TreeNode curTree = new TreeNode();
            for (int i = 0; i < n; i++) {
                curTree = myQueue.poll();
                level.add(curTree.val);
                if (curTree.left != null) myQueue.offer(curTree.left);
                if (curTree.right != null) myQueue.offer(curTree.right);
            }
            result.add(level);
        }
        return result;
    }
}