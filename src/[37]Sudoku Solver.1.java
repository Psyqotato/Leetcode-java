class Solution {
    List<Character> nums = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public boolean trySudoku(int[][]rows, int[][]columns, int[][][]subboxes, char[][] board, int i) {
        for (int i1 = i; i1 < 9; i1++) {
            for (int j1 = 0; j1 < 9; j1++) {
                if (board[i1][j1] == '.') {
                    for (int num = 0; num < 9; num++) {
                        board[i1][j1] = nums.get(num);
                        rows[i1][num]++;
                        columns[j1][num]++;
                        subboxes[i1 / 3][j1 / 3][num]++;
                        if (rows[i1][num] > 1 || columns[j1][num] > 1 || subboxes[i1 / 3][j1 / 3][num] > 1 || !trySudoku(rows, columns, subboxes, board, i1)) {
                            rows[i1][num]--;
                            columns[j1][num]--;
                            subboxes[i1 / 3][j1 / 3][num]--;
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
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]) - 1;
                    rows[i][num]++;
                    columns[j][num]++;
                    subboxes[i / 3][j / 3][num]++;
                }
            }
        }

        trySudoku(rows, columns, subboxes, board, 0);
    }

}