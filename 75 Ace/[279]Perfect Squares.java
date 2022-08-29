class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        return numSq(n);
    }
    public int numSq(int n) {
        if (memo[n] != 0) return memo[n];
        int i = (int)Math.sqrt(n), result = n;
        if (i * i == n) {
            memo[n] = 1;
            return 1;
        }
        while (i != 0) {
            result = Math.min(result, numSq(n - i * i));
            i--;
        }
        memo[n] = result + 1;
        return memo[n];
    }
}