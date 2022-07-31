class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, nums, result);
        return result;
    }

    public void backTrack (int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1 && !result.contains(Arrays.stream(nums).boxed().collect(Collectors.toList()))) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = i; j < nums.length; j++){
            if (j == i || nums[j] != nums[i]) {
                swap(i, j, nums);
                backTrack(i + 1, nums, result);
                swap(i, j, nums);
            }
        }
    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}