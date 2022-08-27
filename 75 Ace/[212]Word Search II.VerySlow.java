class Solution {
    char[][] boards;
    HashSet<String> result;
    HashSet<String> wordSet;
    boolean[][] used;
    int m, n;
    StringBuffer word;
    public List<String> findWords(char[][] board, String[] words) {
        boards = board;
        result = new HashSet<>();
        wordSet = new HashSet<>();
        word = new StringBuffer();
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (String w : words) wordSet.add(w);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                constructWord(i, j);
            }
        }
        return new LinkedList<>(result);
    }
    void constructWord(int i, int j) {
        if (used[i][j] || word.length() == 10) return;
        word.append(boards[i][j]);
        if (wordSet.contains(word.toString())) {
            result.add(word.toString());
            wordSet.remove(word.toString());
        }
        used[i][j] = true;
        if (i > 0) constructWord(i - 1, j);
        if (i < m - 1) constructWord(i + 1, j);
        if (j > 0) constructWord(i, j - 1);
        if (j < n - 1) constructWord(i, j + 1);
        used[i][j] = false;
        word.deleteCharAt(word.length() - 1);
    }
}