class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        int end = nums.length - 1;
        for (int times = 1; times < k; times++) {
            boolean flag = false;
            for (int i = end - 1; i >= 0 && flag == false; i--){
                if (nums[i] >= nums[end]) {
                    for (int t = i; t < nums.length - 1; t++) {
                        if (nums[t] > nums[t + 1]) {
                            int temp = nums[t]; nums[t] = nums[t + 1]; nums[t + 1] = temp;
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
        String result = "";
        for (int i = 0; i < n; i++) result += nums[i];
        return result;
    }
}