class Solution {

    int m, n;
    int[][] memo;
    int[] nums, multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        m = multipliers.length;
        n = nums.length;
        this.nums = nums;
        this.multipliers = multipliers;
        memo = new int[m][m];
        return dp(0, n - 1, 0);
    }

    int dp(int left, int right, int k){
        if (k == m - 1) return Math.max(nums[left] * multipliers[k], nums[right] * multipliers[k]) ;
        if (memo[left][k] != 0) return memo[left][k];
        memo[left][k] = Math.max(dp(left + 1, right, k + 1) + nums[left] * multipliers[k], dp(left, right - 1, k + 1) + nums[right] * multipliers[k]);
        return memo[left][k];
    }

}