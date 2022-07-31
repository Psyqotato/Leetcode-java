class Solution {
    public int strStr(String haystack, String needle) {
        int[][] dp;
        int M = needle.length();
        int N = haystack.length();

        dp = new int[M][256];
        dp[0][needle.charAt(0)] = 1;

        int shadow = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[shadow][c];
            }
            dp[j][needle.charAt(j)] = j + 1;
            shadow = dp[shadow][needle.charAt(j)];
        }

        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == M) return i - M + 1;
        }
        return -1;
    }
}