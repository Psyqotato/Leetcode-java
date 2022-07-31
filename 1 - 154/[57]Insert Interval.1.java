class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length - 1;
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        int[][] result = new int[n + 2][2];

        for (int i = 0;i <= n;i++) {
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }
        left[n + 1] = newInterval[0];
        right[n + 1] = newInterval[1];

        Arrays.sort(left);
        Arrays.sort(right);

        int left_p = 0, right_p = 0, left_nxt = 1, i = 0;
        while (right_p <= n + 1) {
            while (left_nxt <= n + 1 && left[left_nxt] <= right[right_p]) {
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