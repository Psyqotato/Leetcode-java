class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_none = 0, dp_i_hold = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = dp_i_none;
            dp_i_none = Math.max(dp_i_none, dp_i_hold + prices[i]);
            dp_i_hold = Math.max(dp_i_hold, temp - prices[i]);
        }
        return dp_i_none;
    }
}