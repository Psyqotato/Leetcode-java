
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] result;
    int m, n;
    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        result = new int[n];
        for (int i = 0; i < n; i++) {
            ballFall(grid, i);
        }
        return result;
    }
    void ballFall(int[][] grid, int i) {
        int start = i, row = 0;
        while (row != m && start != -1 && start != n){
            if (grid[row][start] == -1) {
                if (start > 0 && grid[row][start - 1] == -1) {
                    start = start - 1;
                }else{
                    start = -1;
                }
            }else if (grid[row][start] == 1) {
                if (start < n - 1 && grid[row][start + 1] == 1) {
                    start = start + 1;
                }else{
                    start = -1;
                }
            }
            row++;
        }
        if (row == m) {
            result[i] = start;
        }else{
            result[i] = -1;
        }
    }
}