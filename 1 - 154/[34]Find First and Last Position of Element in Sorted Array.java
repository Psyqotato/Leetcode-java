class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int left = 0, right = nums.length - 1;
        if (target < nums[left] || target > nums[right] || nums.length == 0) return new int[]{-1,-1};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (nums[left - 1] == target) {
            right = left = left - 1;
            while (nums[left] == target && left >0) left--;
            return  (nums[left] == target)? new int[]{left, right} : new int[]{left + 1, right};
        }
        return new int[]{-1,-1};
    }
}