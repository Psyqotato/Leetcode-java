class Solution {

    int m, n;
    int[][] memo;
    int[] _nums, _multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        m = multipliers.length;
        n = nums.length;
        _nums = nums;
        _multipliers = multipliers;
        int left = 0, right = n - 1;
        memo = new int[m][m];
        return dp(left, right, 0);
    }

    int dp(int left, int right, int k){
        if (k == m - 1) return Math.max(_nums[left] * _multipliers[k], _nums[right] * _multipliers[k]) ;
        if (memo[left][k] != 0) return memo[left][k];
        memo[left][k] = Math.max(dp(left + 1, right, k + 1) + _nums[left] * _multipliers[k], dp(left, right - 1, k + 1) + _nums[right] * _multipliers[k]);
        return memo[left][k];
    }

}