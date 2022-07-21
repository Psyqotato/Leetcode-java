import java.util.Arrays;

class Solution {

    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length();
        if (t != m + n) return false;
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return isInter(s1, 0, s2, 0, s3);
    }
    public boolean isInter(String s1, int i, String s2, int j, String s3) {
        if (i + j == s3.length()) return true;
        if (memo[i][j] == 0) return false;
        if (memo[i][j] == 1) return true;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (isInter(s1, i + 1, s2, j, s3)){
                memo[i+1][j] = 1;
                return true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (isInter(s1, i, s2, j + 1, s3)) {
                memo[i][j+1] = 1;
                return true;
            }
        }
        memo[i][j] = 0;
        return false;
    }
}