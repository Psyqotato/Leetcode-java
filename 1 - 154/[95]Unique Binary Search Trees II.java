
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int low, int high) {
        List<TreeNode> result = new LinkedList<>();
        if (low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i++){
            List<TreeNode> leftTree = buildTree(low, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, high);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    temp.right = right;
                    result.add(temp);
                }
            }
        }
        return result;
    }
}