import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second) {
                return true;
            }else if (nums[i] > first) {
                second = nums[i];
            }else if (nums[i] < first) {
                first = nums[i];
            }
        }
        return false;
    }
}