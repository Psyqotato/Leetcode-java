import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList result = new ArrayList();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int kPin = nums.length;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > 0) break;
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                for (int k = Math.min(nums.length, kPin - 1); k >= j + 1; k--) {
                    if (nums[i] + nums[j] + nums[k] > 0) continue;
                    if (nums[i] + nums[j] + nums[k] < 0) break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        kPin = k;
                        break;
                    }
                }
            }
        }
        return result;
    }
}