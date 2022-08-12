import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int m, n;
    Queue<Integer> myQue = new LinkedList<>();
    HashMap<Integer, Integer> myMap = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean flag;
    boolean[] used;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        used = new boolean[m * n];
        for (int j = 0; j < n; j++) {
            myQue.add(j);
            used[j] = true;
        }
        for (int i = 1; i < m; i++) {
            myQue.add(i * n);
            used[i * n] = true;
        }
        while(!myQue.isEmpty()) {
            lowToHigh(myQue.poll(), heights);
        }

        used = new boolean[m * n];
        flag = true;
        for (int j = 0; j < n; j++) {
            myQue.add((m - 1) * n + j);
            used[(m - 1) * n + j] = true;
        }
        for (int i = 0; i < m - 1; i++) {
            myQue.add(i * n + n - 1);
            used[i * n + n - 1] = true;
        }
        while(!myQue.isEmpty()) {
            lowToHigh(myQue.poll(), heights);
        }

        return result;

    }
    void lowToHigh(int value,  int[][] heights) {
        int i = value / n, j = value % n;
        if (i > 0 && !used[(i - 1) * n + j] && heights[i - 1][j] >= heights[i][j]) {
            myQue.add((i - 1) * n + j);
            used[(i - 1) * n + j] = true;
        }
        if (i < m - 1 && !used[(i + 1) * n + j] && heights[i + 1][j] >= heights[i][j]) {
            myQue.add((i + 1) * n + j);
            used[(i + 1) * n + j] = true;
        }
        if (j > 0 && !used[i * n + j - 1] && heights[i][j - 1] >= heights[i][j]) {
            myQue.add(i * n + j - 1);
            used[i * n + j - 1] = true;
        }
        if (j < n - 1 && !used[i * n + j + 1] && heights[i][j + 1] >= heights[i][j]) {
            myQue.add(i * n + j + 1);
            used[i * n + j + 1] = true;
        }
        if (flag && myMap.getOrDefault(i * n + j, 0).intValue() == 1) result.add(Arrays.asList(i,j));
        myMap.put(i * n + j, myMap.getOrDefault(i * n + j, 0) + 1);
    }
}