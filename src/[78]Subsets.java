import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> solution = new LinkedList<>();
        result.add(new LinkedList<>(solution));
        backTrack(nums, solution, result, 0);
        return result;
    }
    public void backTrack(int[] nums, List<Integer> solution, List<List<Integer>> result, int index) {
        if (!solution.isEmpty()) result.add(new LinkedList<>(solution));
        if (solution.size() == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            solution.add(nums[i]);
            backTrack(nums, solution, result, i + 1);
            solution.remove(solution.get(solution.size() - 1));
        }
    }
}