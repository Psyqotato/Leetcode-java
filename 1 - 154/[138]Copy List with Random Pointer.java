
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> myMap = new HashMap<>();
        if (head == null) return head;
        Node cloneNode = new Node(head.val);
        Node dummy = cloneNode;
        Node p = cloneNode;
        Node hp = head;
        myMap.put(head, cloneNode);
        while(head.next != null) {
            head = head.next;
            cloneNode.next = new Node(head.val);
            cloneNode = cloneNode.next;
            myMap.put(head, cloneNode);
        }
        while(p != null) {
            p.random = myMap.get(hp.random);
            p = p.next;
            hp = hp.next;
        }
        return dummy;
    }
}