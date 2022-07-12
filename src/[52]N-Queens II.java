class Solution {
    int result = 0;

    public int totalNQueens(int n) {
        int[] solution = new int[n];
        int[] queens = new int[n];
        for (int i = 1; i <= n; i++) queens[i-1] = i;
        boolean[] used = new boolean[n];
        backTrack(0, solution, queens, used);
        return result;
    }

    public void backTrack(int row, int[] solution, int[] queens, boolean[] used) {
        int n = solution.length;
        if (solution[n - 1] != 0) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++){
            if (used[i] == true) continue;
            if (queenValid(queens[i], row, solution)) {
                solution[row] = queens[i];
                used[i] = true;
                backTrack(row + 1, solution, queens, used);
                used[i] = false;
                solution[row] = 0;
            }
        }
    }

    public boolean queenValid (int position, int row, int[] solution) {
        for (int i = 0; i < row; i++) {
            if ((position - row) == solution[i] - i) return false;
            if ((row - i) == solution[i] - position) return false;
        }
        return true;
    }
}