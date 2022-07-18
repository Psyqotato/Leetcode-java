import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> solution = new LinkedList<>();
        backTrack(solution, result, k , 0, n);
        return result;
    }
    public void backTrack(List<Integer> solution, List<List<Integer>> result, int k, int index, int n) {
        if (solution.size() == k) {
            result.add(new LinkedList<>(solution));
            return;
        }
        for (int i = index; i < n; i++) {
            solution.add(i + 1);
            backTrack(solution, result, k, i + 1, n);
            solution.remove(solution.get(solution.size() - 1));
        }
    }
}