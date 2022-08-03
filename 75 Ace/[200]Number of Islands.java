
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    floodIsland(grid, i, j);
                }
            }
        }
        return result;
    }
    void floodIsland(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';
        floodIsland(grid, i - 1, j);
        floodIsland(grid, i ,j - 1);
        floodIsland(grid, i + 1, j);
        floodIsland(grid, i, j + 1);
    }
}