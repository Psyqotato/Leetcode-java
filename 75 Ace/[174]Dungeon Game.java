class Solution {
    int m, n;
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return router(dungeon, 0, 0);
    }

    int router(int[][] dungeon, int i, int j) {
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (memo[i][j] != -1) return memo[i][j];
        if (i == m - 1 && j == n - 1) return (dungeon[i][j] < 0)? 1 - dungeon[i][j] : 1;
        int result = Math.min(router(dungeon, i , j + 1), router(dungeon, i + 1, j)) - dungeon[i][j];
        memo[i][j] = (result <= 0)? 1 : result;
        return memo[i][j];
    }
}