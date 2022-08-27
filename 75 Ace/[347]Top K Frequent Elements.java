import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] num = new int[20001];
        for (int value : nums) {
            num[value + 10000]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < 20001; i++) {
            if (num[i] != 0) {
                if (pq.size() < k) {
                    pq.offer(new int[]{i - 10000, num[i]});
                }else{
                    if (pq.peek()[1] < num[i]) {
                        pq.poll();
                        pq.offer(new int[]{i - 10000, num[i]});
                    }
                }
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}