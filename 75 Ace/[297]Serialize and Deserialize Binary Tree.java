public class Codec {

    String COMA = ",";
    String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverseSerialize(root, sb);
        return sb.toString();
    }
    public void traverseSerialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(COMA);
            return;
        }

        sb.append(root.val).append(COMA);
        traverseSerialize(root.left, sb);
        traverseSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(COMA)) {
            nodes.addLast(s);
        }
        return traverseDeserialize(nodes);
    }
    public TreeNode traverseDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = traverseDeserialize(nodes);
        root.right = traverseDeserialize(nodes);

        return root;
    }
}