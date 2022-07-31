import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int lwords = words.length, lword = words[0].length(), ls = s.length();
        for (int i = 0; i < lword; i++) {
            if (i + lword * lwords > ls) break;
            HashMap<String, Integer> dict = new HashMap<>();

            for (int j = i; j < i + lwords * lword; j += lword) {
                String sslice = s.substring(j, j + lword);
                dict.put(sslice, dict.getOrDefault(sslice, 0) + 1);
            }

            for (String word : words) {
                dict.put(word, dict.getOrDefault(word,0) - 1);
                if (dict.getOrDefault(word,0) == 0) dict.remove(word);
            }

            for (int k = i; k <= ls - lword * lwords; k += lword) {
                if (k != i) {
                    String wordOut = s.substring(k - lword, k);
                    dict.put(wordOut, dict.getOrDefault(wordOut, 0) - 1);
                    if (dict.getOrDefault(wordOut,0) == 0) dict.remove(wordOut);
                    String wordIn = s.substring(k + lword * lwords - lword, k + lwords * lword);
                    System.out.println(wordIn);
                    dict.put(wordIn, dict.getOrDefault(wordIn, 0) + 1);
                    if (dict.getOrDefault(wordIn,0) == 0) dict.remove(wordIn);
                }
                if (dict.isEmpty()) result.add(k);
            }
        }
        return result;
    }
}