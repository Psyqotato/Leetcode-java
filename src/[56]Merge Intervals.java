import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length - 1;
        if (n == 0) return intervals;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[][] result = new int[n + 1][2];

        for (int i = 0;i <= n;i++) {
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int left_p = 0, right_p = 0, left_nxt = 1, i = 0;
        while (right_p <= n) {
            while (left_nxt <= n && left[left_nxt] <= right[right_p]) {
                left_nxt++;
                right_p++;
            }
            result[i][0] = left[left_p];
            result[i][1] = right[right_p];
            left_p = left_nxt;
            right_p++;
            left_nxt++;
            i++;
        }
        result = Arrays.copyOfRange(result, 0, i);
        return result;
    }
}