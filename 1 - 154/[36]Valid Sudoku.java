class Solution {
    public boolean isValidSudoku(char[][] board) {
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
                    if (rows[i][num] > 1 || columns[j][num] > 1 || subboxes[i / 3][j / 3][num] > 1) return false;
                }
            }
        }
        return true;
    }
}