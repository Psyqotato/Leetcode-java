class Solution {
    int[][] board;
    int m, n;
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        board = matrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                result = Math.max(result, increasingPath(i, j));
            }
        }
        return result;
    }

    public int increasingPath(int i, int j){
        int cur = board[i][j];
        if (memo[i][j] != 0) return memo[i][j];
        int result = 0;
        if (i > 0 && board[i - 1][j] > cur) {
            result = Math.max(result, increasingPath(i - 1, j));
        }
        if (i < m - 1 && board[i + 1][j] > cur) {
            result = Math.max(result, increasingPath(i + 1, j));
        }
        if (j > 0 && board[i][j - 1] > cur) {
            result = Math.max(result, increasingPath(i, j - 1));
        }
        if (j < n - 1 && board[i][j + 1] > cur) {
            result = Math.max(result, increasingPath(i, j + 1));
        }
        memo[i][j] = result + 1;
        return memo[i][j];
    }
}