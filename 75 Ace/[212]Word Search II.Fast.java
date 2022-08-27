class Solution {

    char[][] boards;
    HashSet<String> result;
    HashSet<String> wordSet;
    boolean[][] used;
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        boards = board;
        result = new HashSet<>();
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (String w : words) trie.insert(w);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                constructWord(trie, i, j);
            }
        }
        return new LinkedList<>(result);
    }

    void constructWord(Trie curTrie, int i, int j) {
        char c = boards[i][j];
        if (used[i][j] || !curTrie.children.containsKey(c)) return;
        Trie nextTrie = curTrie.children.get(c);
        if (!"".equals(nextTrie.word)) {
            result.add(nextTrie.word);
        }
        if (!nextTrie.children.isEmpty()) {
            used[i][j] = true;
            if (i > 0) constructWord(nextTrie, i - 1, j);
            if (i < m - 1) constructWord(nextTrie, i + 1, j);
            if (j > 0) constructWord(nextTrie, i, j - 1);
            if (j < n - 1) constructWord(nextTrie, i, j + 1);
            used[i][j] = false;
        }
        if (nextTrie.children.isEmpty()) curTrie.children.remove(c);

    }
}

class Trie{
    String word;
    HashMap<Character, Trie> children;
    boolean isEnd;

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}