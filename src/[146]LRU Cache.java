import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    HashMap<Integer, Node> cacheMap;
    DoubleList cache;
    int capacity;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            makeRecently(key);
            return cacheMap.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cache.size() == capacity) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    public void makeRecently(int key) {
        Node node = cacheMap.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    public void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        cacheMap.put(key, node);
    }

    public void deleteKey(int key) {
        Node node = cacheMap.get(key);
        cache.remove(node);
        cacheMap.remove(key);
    }

    public void removeLeastRecently() {
        Node leastRecNode = cache.removeFirst();
        int leastRecKey = leastRecNode.key;
        cacheMap.remove(leastRecKey);
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) return null;
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */