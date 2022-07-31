
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    HashSet<Node> visited = new HashSet<Node>();
    HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        traverse(node);
        return oldToNew.get(node);
    }

    void traverse (Node node) {
        if (node == null) return;

        if (visited.contains(node)) return;

        visited.add(node);
        if (!oldToNew.containsKey(node)) oldToNew.put(node, new Node(node.val));

        Node cloneNode = oldToNew.get(node);

        for (Node neighbor : node.neighbors) {
            traverse(neighbor);
            Node cloneNeighbor = oldToNew.get(neighbor);
            cloneNode.neighbors.add(cloneNeighbor);
        }
    }
}