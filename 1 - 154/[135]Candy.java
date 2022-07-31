class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int total = 0;
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = (ratings[i] <= ratings[i - 1])? 0 : left[i - 1] + 1;
            right[n - 1 - i] = (ratings[n - 1 - i] <= ratings[n - i])? 0 : right[n - i] + 1;
        }
        for (int i = 0; i < n; i++) {
            total += Math.max(left[i], right[i]) + 1;
        }

        return total;
    }
}