import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    boolean[] used;
    int maxSize = Integer.MAX_VALUE;
    int endWordPosition;
    HashMap<Integer, List<Integer>> layers;
    List<String> wordLists;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        wordLists = wordList;
        if (wordLists.contains(beginWord)) wordLists.remove(wordList.indexOf(beginWord));
        wordLists.remove(wordList.indexOf(endWord));
        wordLists.add(endWord);
        wordLists.add(beginWord);

        int n = wordLists.size();
        used = new boolean[n];
        endWordPosition = n - 2;

        used[n - 1] = true;
        List<Integer> first = new ArrayList<>();
        first.add(n - 1);
        backTrack(first, 2);
        return (maxSize == Integer.MAX_VALUE)? 0 : maxSize;
    }

    void backTrack(List<Integer> faterLayer, int layer){
        List<Integer> curLayer = new ArrayList<>();
        for (int father : faterLayer){
            if (wordDiffer(wordLists.get(father), wordLists.get(endWordPosition)) == true) {
                maxSize = layer;
                return;
            }
            for (int row = endWordPosition - 1; row >= 0; row--) {
                if (used[row] == true) continue;
                if (wordDiffer(wordLists.get(father), wordLists.get(row)) == true) {
                    used[row] = true;
                    curLayer.add(row);
                }
            }
        }
        if (curLayer.isEmpty()) return;
        backTrack(curLayer, layer + 1);
    }

    boolean wordDiffer(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return (count == 1)? true : false;
    }
}