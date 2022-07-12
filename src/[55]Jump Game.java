class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int position = 0, jump = 0;
        while (nums[position] != 0 && position < n && nums[position] + position < n) {
            jump = position + 1;
            for (int i = jump + 1; i <= nums[position] + position; i++) {
                if (nums[i] + i >= nums[jump] + jump ) jump = i;
            }
            position = jump;
        }
        return (nums[position] + position >= n)? true : false;
    }
}