import java.util.List;

class Solution {
    int memo[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        memo = new int[m][m];
        for (int j = 0; j < m - 1; j++) memo[m-1][j] = triangle.get(m - 1).get(j);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = Math.min(memo[i + 1][j], memo[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return memo[0][0];
    }
}