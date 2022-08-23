class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int min = nums[0], max = nums[n - 1];
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > min) left[i] = 1;
            if (nums[i] < min) min = nums[i];
            if (nums[n - i - 1] < max) right[n - i - 1] = 1;
            if (nums[n - i - 1] > max) max = nums[n - i - 1];
        }
        for (int i = 1; i < n - 1; i++) {
            if (left[i] == 1 && right[i] == 1) return true;
        }
        return false;
    }
}