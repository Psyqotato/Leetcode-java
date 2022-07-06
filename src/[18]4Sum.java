import java.util.Arrays;

class Solution {

    List<List<Integer>> threeSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] - target + nums[j] + nums[k] == 0) {
                    List<Integer> three = new ArrayList<>();
                    three.add(nums[i]);
                    three.add(nums[j]);
                    three.add(nums[k]);
                    result.add(three);
                    while (j < k && nums[j + 1] == nums[j]) j++;
                    while (j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                }else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            long res = target - nums[i];
            List<List<Integer>> rest = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), res);
            for (int j = 0; j < rest.size(); j++) {
                rest.get(j).add(nums[i]);
                result.add(rest.get(j));
            }
        }
        return result;
    }
}