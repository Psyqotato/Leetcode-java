import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited, onPath;
    LinkedList<Integer> res;
    int[] result;
    HashMap<Integer, List<Integer>> courseMap;
    boolean flag;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courseMap = new HashMap<Integer, List<Integer>>();
        res = new LinkedList<>();
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int[] row : prerequisites) {
            List<Integer> cur = courseMap.getOrDefault(row[1], new ArrayList<>());
            cur.add(row[0]);
            courseMap.put(row[1], cur);
        }

        for (int cur = 0; cur < numCourses; cur++) {
            traves(cur);
        }
        if (flag) return new int[0];
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = res.get(i);
        return result;
    }

    void traves(int cur) {
        if (onPath[cur]) flag = true;
        if (visited[cur] || flag) return;
        visited[cur] = true;
        onPath[cur] = true;
        for (int next : courseMap.getOrDefault(cur, new ArrayList<>())) {
            traves(next);
        }
        res.addFirst(cur);
        onPath[cur] = false;
    }
}