class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxPrice = new int[n];
        int max = n - 1;
        maxPrice[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--){
            if (prices[i] > prices[max]) max = i;
            maxPrice[i] = max;
        }
        int result = 0;
        for (int i = 0; i < n - 1; i ++) {
            result = Math.max(result, prices[maxPrice[i]] - prices[i]);
        }
        return result;
    }
}