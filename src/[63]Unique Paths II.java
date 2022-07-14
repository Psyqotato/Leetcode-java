class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int result = 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int i = 0;
        while(i < n && obstacleGrid[0][i] != 1) {
            obstacleGrid[0][i] = -1;
            i++;
        }
        while (i < n) {
            obstacleGrid[0][i] = 0;
            i++;
        }
        i = 1;
        while (i < m && obstacleGrid[i][0] != 1) {
            obstacleGrid[i][0] = -1;
            i++;
        }
        while (i < m) {
            obstacleGrid[i][0] = 0;
            i++;
        }

        for (i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }else{
                    obstacleGrid[i][j] = 0;
                }

            }
        }
        return  0 - obstacleGrid[m-1][n-1];
    }
}