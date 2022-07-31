class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0 && flag == false; i--){
            if (nums[i] >= nums[end]) {
                for (int k = i; k < nums.length - 1; k++) {
                    if (nums[k] > nums[k + 1]) {
                        int temp = nums[k]; nums[k] = nums[k + 1]; nums[k + 1] = temp;
                    }
                }
                continue;
            }
            flag = true;
            for (int j = i + 1; j <= end; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
                    break;
                }
            }
        }
    }
}