import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int[] lr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            lr[2 * i] = buildings[i][0];
            lr[2 * i + 1] = buildings[i][1];
        }
        Arrays.sort(lr);

//        building index;
        int index = 0;
        int maxHeight = 0;
        for (int value : lr) {
            while (index < n && buildings[index][0] <= value) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while (pq.size() != 0 && pq.peek()[0] <= value) {
                pq.poll();
            }
            maxHeight = (pq.isEmpty())? 0 : pq.peek()[1];
            if (result.size() == 0 || maxHeight != result.get(result.size() - 1).get(1)) {
                result.add(Arrays.asList(value, maxHeight));
            }
        }
        return result;
    }
}