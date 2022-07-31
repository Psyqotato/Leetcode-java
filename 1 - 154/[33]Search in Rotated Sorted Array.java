class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        if (target >= nums[left]) {
            while (left <= mid && mid <= right) {
                while (nums[mid] < nums[left] && mid != left) {
                    right = mid; mid = (left + right) / 2;
                }
                if (nums[mid] > target) {
                    right = mid; mid = (left + right) / 2;
                }else if (nums[mid] < target){
                    left = mid; mid = (left + right) / 2;
                }else{
                    return mid;
                }
                if ((left == mid || mid == right) && nums[mid] != target) return -1;
            }
        }else if (target <= nums[right]) {
            while (left <= mid && mid <= right) {
                while (nums[mid] > nums[right] && mid != left) {
                    left = mid; mid = (left + right) / 2;
                }
                if (nums[mid] > target) {
                    right = mid; mid = (left + right) / 2;
                }else if (nums[mid] < target) {
                    left = mid; mid = (left + right) / 2;
                }else{
                    return mid;
                }
                if ((left == mid || mid == right) && nums[mid] != target) return -1;
            }
        }
        return -1;
    }
}