import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int memo[][];

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(word1, word2, m - 1, n - 1);
    }

    int dp (String word1, String word2, int i, int j) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (memo[i][j] != -1) return memo[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] =  dp(word1, word2, i - 1, j - 1);
        }else{
            memo[i][j] = min(dp(word1, word2, i, j - 1) + 1, dp(word1, word2, i - 1, j) + 1, dp(word1, word2, i - 1, j - 1) + 1);
        }
        return memo[i][j];
    }

    int min (int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}