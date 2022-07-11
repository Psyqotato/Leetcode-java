class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] position = new int[nums.length + 2];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                position[nums[i]] = 1;
                while (p <= Math.max(nums[i],p)) {
                    if (position[p] == 0) break;
                    p++;
                }
            }
        }
        return p;
    }
}