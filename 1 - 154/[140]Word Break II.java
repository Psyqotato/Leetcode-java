import jdk.internal.joptsimple.internal.Strings;

import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    HashSet<String> words;
    int lenMax = 0, lenMin = 0;
    int[] memo;
    List<String> result = new ArrayList<>();
    LinkedList<String> solution = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
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
        dp(s, 0);
        return result;
    }

    boolean dp (String s, int i) {
        if (i > n - 1) {
            String str = String.join(" ", solution);
            result.add(str);
            return true;
        }
        if (memo[i] == 0) return false;
        for (int len = lenMin; len <= lenMax && len < n - i + 1; len++) {
            if (words.contains(s.substring(i, i + len))) {
                solution.add(s.substring(i, i + len));
                if (dp(s, i + len)) {
                    memo[i] = 1;
                };
                solution.removeLast();
            }
        }
        if (memo[i] != 1) memo[i] = 0;
        return (memo[i] == 1);
    }
}