class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] used_m = new boolean[m];
        boolean[] used_n = new boolean[n];
        boolean[][] used_mn = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) used_mn[i][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (used_mn[i][j] == true && matrix[i][j] == 0) {
                    if (used_m[i] == false) {
                        setRowZeroes(matrix, i);
                        used_m[i] = true;
                    }
                    if (used_n[j] == false) {
                        setColumnZeroes(matrix, j);
                        used_n[j] = true;
                    }
                }
            }
        }
    }
    public void setRowZeroes(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
    public void setColumnZeroes(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }
}