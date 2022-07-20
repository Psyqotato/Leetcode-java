import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result;
    LinkedList<Integer> solution;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new LinkedList<>();
        solution = new LinkedList<>();
        backTrack(nums, 0);
        return result;
    }

    public void backTrack(int[] nums, int j) {
        result.add(new LinkedList<>(solution));
        if (j >= nums.length || solution.size() == nums.length) return;
        int lastOut = nums[j] - 1;
        for (int i = j; i < nums.length; i++) {
            if (nums[i] == lastOut) continue;
            solution.add(nums[i]);
            backTrack(nums, i + 1);
            lastOut = solution.getLast();
            solution.removeLast();
        }
    }
}