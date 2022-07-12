class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> solution = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, solution, result);
        return result;
    }

    public void backTrack (int[] nums, boolean[] used, List<Integer> solution, List<List<Integer>> result) {
        if (solution.size() == nums.length) {
            result.add(new LinkedList<>(solution));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            solution.add(nums[i]);
            backTrack(nums, used, solution, result);
            int lastOut = solution.get(solution.size() - 1);
            solution.remove(solution.size() - 1);
            used[i] = false;
            while (i + 1 < nums.length && nums[i + 1] == lastOut) i++;
        }
    }
}