import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, Integer> memo2 = new HashMap<>();
    HashMap<Integer, Integer> memo3 = new HashMap<>();
    HashMap<Integer, Integer> memo4 = new HashMap<>();

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            result += threeSumCount(nums2, nums3, nums4, 0 - nums1[i]);
        }
        return result;
    }

    int threeSumCount(int[] nums2, int[] nums3, int[] nums4, int target) {
        if (memo2.get(target) != null) return memo2.get(target);
        int result = 0;
        for (int i = 0; i < nums2.length; i++) {
            result += twoSumCount(nums3, nums4, target - nums2[i]);
        }
        memo2.put(target, result);
        return result;
    }

    int twoSumCount(int[] nums3, int[] nums4, int target) {
        if (memo3.get(target) != null) return memo3.get(target);
        int result = 0;
        for (int i = 0; i < nums3.length; i++) {
            result += sumCount(nums4, target - nums3[i]);
        }
        memo3.put(target, result);
        return result;
    }

    int sumCount(int[] nums4, int target) {
        if (memo4.get(target) != null) return memo4.get(target);
        int result = 0;
        for (int i = 0; i < nums4.length; i++) {
            if (nums4[i] == target) result++;
        }
        memo4.put(target, result);
        return result;
    }
}