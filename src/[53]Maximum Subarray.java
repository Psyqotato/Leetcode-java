class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp_pre = nums[0];
        int dp_cur = dp_pre;
        int result = dp_cur;
        for (int i = 1; i < n; i++){
            dp_cur = Math.max(dp_pre + nums[i], nums[i]);
            result = Math.max(result, dp_cur);
            dp_pre = dp_cur;
        }
        return result;
    }
}