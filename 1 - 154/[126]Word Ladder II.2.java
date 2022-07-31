import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<List<String>> result = new LinkedList<>();
    LinkedList<String> solution = new LinkedList<>();
    boolean[] used;
    int maxSize;
    int wordSize;
    int endWordPosition;
    int beginPosition;
    List<String> wordLists;
    HashMap<Integer, List<String>> layers;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();

        wordSize = beginWord.length();
        wordLists = wordList;
        if (wordList.contains(beginWord)) wordList.remove(wordList.indexOf(beginWord));
        wordList.remove(wordList.indexOf(endWord));
        wordList.add(endWord);
        wordList.add(beginWord);
        int n = wordList.size();
        used = new boolean[n];
        maxSize = 0;
        endWordPosition = n - 2;
        beginPosition = n - 1;
        layers = new HashMap<Integer, List<String>>();

        List<String> firstLayer = new ArrayList<>();
        firstLayer.add(wordLists.get(beginPosition));
        used[n - 1] = true;
        layers.put(1, firstLayer);
        backTrack(firstLayer, 2);

        if (maxSize < 2) return new ArrayList<>();
        solution.add(wordLists.get(endWordPosition));
        backTrackSolution(wordLists.get(endWordPosition), maxSize - 1);
        return result;
    }

    public void backTrack(List<String> fatherLayer, int layer){
        List<String> curLayer = new ArrayList<>();
        for (String father : fatherLayer) {
            if (wordDiffer(father, wordLists.get(endWordPosition))) {
                maxSize = layer;
                return;
            }
            for (int row = endWordPosition - 1; row >= 0; row--) {
                if (used[row] == true) continue;
                if (wordDiffer(father, wordLists.get(row))) {
                    used[row] = true;
                    curLayer.add(wordLists.get(row));
                }
            }
        }
        if (curLayer.isEmpty()) return;
        layers.put(layer, curLayer);
        backTrack(curLayer, layer + 1);
    }

    public void backTrackSolution(String son, int layer) {
        if (layer == 1 && wordDiffer(son, wordLists.get(beginPosition))) {
            solution.addFirst(wordLists.get(beginPosition));
            result.add(new ArrayList<>(solution));
            return;
        }else if(layer == 1 && !wordDiffer(son, wordLists.get(beginPosition))) {
            return;
        }
        for (String cur : layers.get(layer)){
            if (wordDiffer(son, cur)) {
                solution.addFirst(cur);
                backTrackSolution(cur, layer - 1);
                if (solution.size() == maxSize) {
                    solution.removeFirst();
                }
                solution.removeFirst();
            }
        }
    }

    boolean wordDiffer(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return (count == 1)? true : false;
    }
}