import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dp;
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> solution = new LinkedList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new int[n][n];

        backTrack(s, 0);
        return result;
    }

    void backTrack(String s, int position) {
        if (position == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int j = position; j < n; j++) {
            if (isPalindrome(s, position, j) == 1) {
                solution.add(s.substring(position, j + 1));
                backTrack(s, j + 1);
                solution.removeLast();
            }
        }
    }

    public int isPalindrome(String s, int start, int end) {
        if (dp[start][end] != 0) return dp[start][end];
        if (start >= end) {
            dp[start][end] = 1;
        }else if(s.charAt(start) == s.charAt(end)){
            dp[start][end] = isPalindrome(s, start + 1, end - 1);
        }else{
            dp[start][end] = -1;
        }
        return dp[start][end];
    }
}