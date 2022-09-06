class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> myQue = new LinkedList<>();
        myQue.offer(root);
        List<Double> result = new LinkedList<>();
        while(!myQue.isEmpty()) {
            int n = myQue.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = myQue.poll();
                sum += cur.val;
                if (cur.left != null) myQue.offer(cur.left);
                if (cur.right != null) myQue.offer(cur.right);
            }
            result.add(sum / n);
        }
        return result;
    }
}