import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int intervalEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= intervalEnd) {
                count++;
                intervalEnd = interval[1];
            }
        }
        return intervals.length - count;
    }
}