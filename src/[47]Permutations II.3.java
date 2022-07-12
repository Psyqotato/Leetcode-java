import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            solution.add(nums[i]);
            backTrack(nums, used, solution, result);
            solution.remove(solution.size() - 1);
            used[i] = false;
        }
    }
}