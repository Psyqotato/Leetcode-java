class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        return numSq(n);
    }
    public int numSq(int n) {
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];
        int i = (int)Math.sqrt(n), result = n;
        while (i != 0) {
            result = Math.min(result, 1 + numSq(n - i * i));
            i--;
        }
        memo[n] = result;
        return result;
    }
}