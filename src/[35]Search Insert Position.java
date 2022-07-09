class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (target < nums[0]) return left;
        if (target > nums[right]) return right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target){
                return mid;
            }
        }
        return (nums[right] < target)? right + 1 : right;
    }
}