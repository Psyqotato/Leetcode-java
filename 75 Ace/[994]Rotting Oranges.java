import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] used;
    HashMap<Integer, List<Integer>> myMap = new HashMap<Integer, List<Integer>>();
    int m, n, fresh;
    public int orangesRotting(int[][] grid) {
        List<Integer> rotting = new ArrayList<>();
        m = grid.length;
        n = grid[0].length;
        used = new boolean[m * n];
        fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    used[i * n + j] = true;
                    rotting.add(i * n + j);
                }
                if (grid[i][j] == 0) used[i * n + j] = true;
            }
        }
        if (fresh != 0 && rotting.isEmpty()) return -1;
        if (fresh == 0) return 0;
        myMap.put(0, rotting);
        int minute = 0;
        while (!myMap.get(minute).isEmpty()) {
            minute++;
            rottenAround(myMap.get(minute - 1), minute);
        }
        return (fresh != 0)? -1 : minute - 1;
    }

    void rottenAround(List<Integer> rotten, int minute) {
        List<Integer> temp = new ArrayList<>();
        for (int value : rotten) {
            int j = value % n , i = value / n;
            if (i > 0 && !used[(i - 1) * n + j]) {
                used[(i - 1) * n + j] = true;
                fresh--;
                temp.add((i - 1) * n + j);
            }
            if (i < m - 1 && !used[(i + 1) * n + j]) {
                used[(i + 1) * n + j] = true;
                fresh--;
                temp.add((i + 1) * n + j);
            }
            if (j > 0 && !used[i * n + j - 1]) {
                used[i * n + j - 1] = true;
                fresh--;
                temp.add(i * n + j - 1);
            }
            if (j < n - 1 && !used[i * n + j + 1]) {
                used[i* n + j + 1] = true;
                fresh--;
                temp.add(i * n + j + 1);
            }
        }
        myMap.put(minute, temp);
    }
}