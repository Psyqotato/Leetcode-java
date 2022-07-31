import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        int[][] dp;
        List<Integer> result = new ArrayList<>();
        List<String> newWords = calPermutation(words, 0, new ArrayList<>());
        for (String word : newWords) {
            System.out.println(s);
            dp = kmp(word);
            System.out.println(dp[0][0]);
            List<Integer> nums = search(s, word, dp);
            if (!nums.isEmpty()){
                for (int num : nums) result.add(num);
            }
        }
        return result;
    }

    public int factorial(int n) {
        return (n == 1) ? 1 : n * factorial(n - 1);
    }

    public List<String> calPermutation(String[] words, int start, List result) {
        if (start == words.length - 1) {
            String ans = new String();
            for (String word : words) {
                ans += word;
            }
            if (!result.contains(ans)) result.add(ans);
        }
        for (int i = start; i < words.length; i++) {
            if (i == start || words[i] != words[start]) {
                swap(words, i, start);
                calPermutation(words, start + 1, result);
                swap(words, i, start);
            }
        }

        return result;
    }

    public void swap (String[] words, int i, int j) {
        String temp;
        temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public int[][] kmp(String wordCombine) {
        int[][] dp;
        int M = wordCombine.length();

        dp = new int[M][256];
        dp[0][wordCombine.charAt(0)] = 1;

        int shadow = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[shadow][c];
            }
            dp[j][wordCombine.charAt(j)] = j + 1;
            shadow = dp[shadow][wordCombine.charAt(j)];
        }
        return dp;
    }

    public List<Integer> search(String s, String wordCombine, int[][] dp) {
        List<Integer> result = new ArrayList<>();
        int M = wordCombine.length();
        int N = s.length();

        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][s.charAt(i)];
            if (j == M) {
                result.add(i - M + 1);
                j = 0;
                i = i - M + 1;
            }
        }
        return result;
    }
}