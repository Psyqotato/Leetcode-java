import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;

    public String getPermutation(int n, int k) {
        String[] nums = new String[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = "" + i;
        boolean[] used = new boolean[n];
        List<String> res = new LinkedList<>();
        String solution = "";
        backTrack(k, nums, used, solution, res);
        return res.get(res.size() - 1);
    }

    public void backTrack(int k, String[] nums, boolean[] used, String solution, List<String> res) {
        if (count == k) return;
        if (solution.length() == nums.length) {
            res.add(new String(solution));
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            solution += nums[i];
            used[i] = true;
            backTrack(k, nums, used, solution, res);
            used[i] = false;
            solution = solution.substring(0, solution.length() - 1);
        }
    }
}