import java.util.Arrays;

class Solution {

    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(s, 0, t, 0);

    }

    public int dp(String s, int si, String t, int ti) {
        if (ti == t.length()) return 1;
        if (s.length() - si < t.length() - ti) return 0;
        if (memo[si][ti] != -1) return memo[si][ti];

        int result = 0;
        for (int j = si; j < s.length(); j++) {
            if (s.charAt(j) == t.charAt(ti)) {
                result += dp(s, j + 1, t, ti + 1);
            }
        }
        memo[si][ti] = result;
        return result;
    }
}