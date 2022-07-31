import java.util.*;

class Solution {
    LinkedList<List<String>> result = new LinkedList<>();
    LinkedList<String> solution = new LinkedList<>();
    boolean[] used;
    int maxSize;
    int[][] dp;
    int[] positionMax;
    int wordSize;
    HashSet<String> paths;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();
        paths = new HashSet<>();
        wordSize = beginWord.length();
        if (wordList.contains(beginWord)) wordList.remove(wordList.indexOf(beginWord));
        wordList.remove(wordList.indexOf(endWord));
        wordList.add(endWord);
        int n = wordList.size();
        used = new boolean[n];
        maxSize = n + 1;
        positionMax = new int[n + 1];
        Arrays.fill(positionMax, n + 1);
        dp = new int[n + 1][n + 1];
        wordList.add(beginWord);
        for (int i = 0; i < n + 1; i++){
            for (int j = 0; j < n + 1; j++) {
                int count = 0, k = -1;
                for (int z = 0; z < wordSize; z++) {
                    if (wordList.get(i).charAt(z) != wordList.get(j).charAt(z)) {
                        k = z;
                        count++;
                    }
                    if (count > 1) break;
                }
                if (count == 1) dp[i][j] = k + 1;
            }
        }

        solution.add(beginWord);
        backTrack(wordList, endWord, n, -1);
        return result;
    }

    public void backTrack(List<String> wordList, String endWord, int i, int p){
        int n = solution.size();
        if (n > maxSize) return;
        if (wordList.get(i).equals(endWord)) {
            while (!result.isEmpty() && result.getLast().size() > solution.size()) result.removeLast();
            maxSize = Math.min(maxSize, solution.size());
            for (String str : solution) paths.add(str);
            result.add(new LinkedList<>(solution));
            return;
        }
        for (int j = wordList.size() - 2; j >= 0;j--) {
            if (solution.size() > maxSize) break;
            if (used[j] == true) continue;
            if (positionMax[j] < n) continue;
            if (dp[i][j] > 0 && dp[i][j] != p) {
                solution.add(wordList.get(j));
                positionMax[j] = n;
                used[j] = true;
                backTrack(wordList, endWord, j, dp[i][j]);
                used[j] = false;
                solution.removeLast();
                if (!paths.contains(wordList.get(j))) positionMax[j] = n - 1;
            }
        }
    }
}