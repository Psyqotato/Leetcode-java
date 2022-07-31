import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];

        for (boolean[] row : dp) Arrays.fill(row, true);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[0][i]){
                cut[i] = 0;
            }else{
                cut[i] = i;
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cut[i] = Math.min(cut[i], cut[j] + 1);
                    }
                }
            }
        }
        return cut[n - 1];
    }
}