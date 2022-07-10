import java.util.List;

class Solution {
    List<Character> nums = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public boolean isValid(char num, int row, int column, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (k != column && board[row][k] == num) return false;
            if (k != row && board[k][column] == num) return false;
            if ((row / 3) * 3 + k / 3 != row && (column / 3) * 3 + k % 3 != column && board[(row / 3) * 3 + k / 3][(column / 3) * 3 + k % 3] == num) return false;
        }
        return true;
    }

    public boolean trySudoku(char[][] board, int i) {
        for (int i1 = i; i1 < 9; i1++) {
            for (int j1 = 0; j1 < 9; j1++) {
                if (board[i1][j1] == '.') {
                    for (char num : nums) {
                        board[i1][j1] = num;
                        if (!isValid(num, i1, j1, board) || !trySudoku(board, i1)) {
                            board[i1][j1] = '.';
                            continue;
                        }
                        return true;
                    }
                    if (board[i1][j1] == '.') return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {

        trySudoku(board, 0);
    }
}