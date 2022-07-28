import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    HashSet<String> words;
    int lenMax = 0, lenMin = 0;
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        words = new HashSet<String>(wordDict);
        int len;
        for (String word : words) {
            len = word.length();
            lenMax = Math.max(lenMax, len);
            lenMin = Math.min(lenMin, len);
        }
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(s, 0);

    }
    boolean dp (String s, int i) {
        if (i > n - 1) return true;
        if (memo[i] == 0) return false;
        for (int len = lenMin; len <= lenMax && len < n - i + 1; len++) {
            if (words.contains(s.substring(i, i + len))) {
                if (dp(s, i + len)) return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}