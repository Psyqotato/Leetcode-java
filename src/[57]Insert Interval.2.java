import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean newIn = false;
        List<int[]> resList = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!newIn) {
                    resList.add(new int[]{left, right});
                    newIn = true;
                }
                resList.add(interval);
            }else if (interval[1] < left) {
                resList.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!newIn) {
            resList.add(new int[]{left, right});
        }
        int[][] result = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }
}