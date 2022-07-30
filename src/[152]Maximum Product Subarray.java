
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int lastMax, lastMin;
        int curMax = nums[0], curMin = nums[0], result = nums[0];
        for (int i = 1; i < n; i++) {
            lastMax = curMax;
            lastMin = curMin;
            curMax = maxThree(nums[i], lastMax * nums[i], lastMin * nums[i]);
            curMin = minThree(nums[i], lastMax * nums[i], lastMin * nums[i]);
            result = Math.max(result, curMax);
        }
        return result;
    }
    int maxThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    int minThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}