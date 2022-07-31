class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left < right) {
            while (left + 1 < right && nums[left + 1] == nums[left]) left++;
            while (right - 1 > left && nums[right - 1] == nums[right]) right--;
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            }else if (nums[mid] < nums[left]){
                right = mid;
            }else if (nums[mid] == nums[left]) {
                return nums[right];
            }
        }
        return nums[right];
    }
}