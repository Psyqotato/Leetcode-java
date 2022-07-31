class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList result = new ArrayList();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(new int[]{nums[i],nums[j],nums[k]});
                    while (j < k && nums[j + 1] == nums[j]) j++;
                    while (j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                }else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}