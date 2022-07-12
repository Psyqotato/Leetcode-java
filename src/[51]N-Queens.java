class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[] solution = new int[n];
        int[] queens = new int[n];
        for (int i = 1; i <= n; i++) queens[i-1] = i;
        boolean[] used = new boolean[n];
        backTrack(0, solution, queens, used, result);
        return result;
    }

    public void backTrack(int row, int[] solution, int[] queens, boolean[] used, List<List<String>> result) {
        int n = solution.length;
        if (solution[n - 1] != 0) {
            String str = ".".repeat(n);
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++){
                String strTemp = (solution[i] != n)? str.substring(0, solution[i] - 1) + "Q" + str.substring(solution[i], n):
                        str.substring(0, solution[i] - 1) + "Q";
                temp.add(strTemp);
            }
            result.add(temp);
        }
        for (int i = 0; i < n; i++){
            if (used[i] == true) continue;
            if (queenValid(queens[i], row, solution)) {
                solution[row] = queens[i];
                used[i] = true;
                backTrack(row + 1, solution, queens, used, result);
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