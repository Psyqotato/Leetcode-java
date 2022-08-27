class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int result = 0;
        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        result = dp(text1, 0, text2, 0);
        return result;
    }

    public int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int result = 0;

        if (text1.charAt(i) == text2.charAt(j)) {
            result = 1 + dp(text1, i + 1, text2, j + 1);
        }else{
            result = Math.max(dp(text1, i , text2, j + 1), dp(text1, i + 1, text2, j));
        }
        memo[i][j] = result;
        return result;
    }
}