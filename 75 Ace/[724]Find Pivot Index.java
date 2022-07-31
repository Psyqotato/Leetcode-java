class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int[] leftSum = new int[n], rightSum = new int[n];
        leftSum[0] = 0;
        rightSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[n - 1 - i] = rightSum[n - i] + nums[n - i];
        }
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }
        return -1;
    }
}