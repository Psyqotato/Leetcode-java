class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            Node current = q.poll();
            for (int i = 1; i <= n - 1; i++) {
                Node next = new Node();
                next = q.poll();
                current.next = next;
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
                current = next;
            }
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);
        }
        return root;
    }
}