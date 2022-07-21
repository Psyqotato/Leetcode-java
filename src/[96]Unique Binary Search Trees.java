class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return build(1,n);
    }
    public int build(int low, int high){
        if (low > high) return 1;
        if ((memo[low][high]) != 0) return memo[low][high];

        int result = 0;
        for (int i = low; i <= high; i++){
            int left = build(low, i - 1);
            int right = build(i + 1, high);
            result += left * right;
        }
        memo[low][high] = result;
        return memo[low][high];
    }
}