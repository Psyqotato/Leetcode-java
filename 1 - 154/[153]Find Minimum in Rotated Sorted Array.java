
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left < right) {
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