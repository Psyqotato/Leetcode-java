import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Integer, List<Integer>> busRoutes;
    Hash
    boolean[] visited;
    List<Integer> end;
    boolean flag;
    boolean[][] memo;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        busRoutes = new HashMap<>();
        visited = new boolean[routes.length];
        end = new ArrayList<>();
        memo = new boolean[routes.length][routes.length];

        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            List<Integer> stop =
            for (int value : routes[i]) {
                if (value == target) end.add(i);
                if (value == source) {
                    cur.add(i);
                    visited[i] = true;
                }
            }
        }
        busRoutes.put(1, cur);
        int buses = 1;
        for (int bus : busRoutes.get(buses)) {
            if (end.contains(bus)) return 1;
        }
        while (busRoutes.get(buses).size() != 0) {
            trackBusStop(routes, buses);
            if (flag) return buses + 1;
            buses++;
        }
        return -1;
    }

    void trackBusStop(int[][] routes, int buses) {
        List<Integer> cur = new ArrayList<>();
        for (int bus : busRoutes.get(buses)) {
            for (int i = 0; i < routes.length; i++) {
                if (visited[i] || memo[bus][i] || memo[i][bus] ) continue;
                if (busToStop(routes, bus, i)) {
                    if (end.contains(i)) {
                        flag = true;
                        return;
                    }
                    cur.add(i);
                    visited[i] = true;
                }
            }
        }
        busRoutes.put(buses + 1, cur);
    }

    boolean busToStop(int[][] routes, int i, int j) {
        for (int iValue : routes[i]) {
            for (int jValue : routes[j]) {
                if (iValue == jValue) {
                    return true;
                };
            }
        }
        memo[i][j] = memo[j][i] = true;
        return false;
    }
}