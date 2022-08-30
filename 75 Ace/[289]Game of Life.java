
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void gameOfLife(int[][] board) {
        int[] neighbors = new int[]{-1, 0, 1};
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCells = 0;
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        if (!(row == 1 && column == 1)) {
                            int neighborR = i + neighbors[row], neighborC = j + neighbors[column];
                            if (neighborR >= 0 && neighborR < m && neighborC >= 0 && neighborC < n && (board[neighborR][neighborC] == 1 || board[neighborR][neighborC] == -1)) {
                                liveCells++;
                            }
                        }
                    }
                }
                if ((board[i][j] == 1 || board[i][j] == -1) && (liveCells < 2 || liveCells > 3)) {
                    board[i][j] = -1;
                }
                if ((board[i][j] == 0 || board[i][j] == -2) && liveCells == 3) {
                    board[i][j] = -2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }
    }
}