class Solution {

    HashMap<Integer, List<Integer>> busRoutes;
    HashMap<Integer, List<Integer>> stopRoutes;
    boolean[] visited;
    boolean flag;
    boolean[][] memo;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        busRoutes = new HashMap<>();
        stopRoutes = new HashMap<>();
        visited = new boolean[routes.length];
        memo = new boolean[routes.length][routes.length];

        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            for (int value : routes[i]) {
                List<Integer> buses = stopRoutes.getOrDefault(value, new ArrayList<>());
                for (int j : buses) {
                    memo[i][j] = memo[j][i] = true;
                }
                buses.add(i);
                stopRoutes.put(value, buses);
                if (value == source) {
                    cur.add(i);
                    visited[i] = true;
                }
            }
        }
        busRoutes.put(1, cur);
        if (busRoutes.get(1) == null || stopRoutes.get(target) == null) return -1;
        int buses = 1;
        for (int bus : busRoutes.get(buses)) {
            if (stopRoutes.get(target).contains(bus)) return 1;
        }
        while (busRoutes.get(buses).size() != 0) {
            trackBusStop(routes, buses, target);
            if (flag) return buses + 1;
            buses++;
        }
        return -1;
    }

    void trackBusStop(int[][] routes, int buses, int target) {
        List<Integer> cur = new ArrayList<>();
        for (int bus : busRoutes.get(buses)) {
            for (int i = 0; i < routes.length; i++) {
                if (visited[i]) continue;
                if (memo[bus][i] || memo[i][bus]) {
                    if (stopRoutes.get(target).contains(i)) {
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
}