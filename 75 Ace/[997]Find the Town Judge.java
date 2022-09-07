class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] judge = new int[n + 1];
        for (int[] row : trust) {
            judge[row[1]]++;
            judge[row[0]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (judge[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}