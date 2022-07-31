import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE, result = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                res = nums[i] + nums[j] + nums[k] - target;
                if (res == 0) {
                    return nums[i] + nums[j] + nums[k];
                }else if (res < 0) {
                    if (0 - res < gap) {
                        gap = 0 - res;
                        result = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                }else{
                    if (res < gap) {
                        gap = res;
                        result = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                    while (j < k && nums[k + 1] == nums[k]) k--;
                }
            }
        }
        return result;
    }
}