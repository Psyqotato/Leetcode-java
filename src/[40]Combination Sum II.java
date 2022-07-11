import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        trackResult(candidates, 0, target, temp, result);
        return result;
    }

    public void trackResult (int[] candidates, int i, int target, List<Integer> temp, List<List<Integer>> result) {
        int j = i;
        if (target == 0 && !result.contains(temp)) {
            result.add(new LinkedList<>(temp));
        }
        if (j >= candidates.length || target < candidates[j]) return;
        while (j < candidates.length && target - candidates[j] >= 0) {
            temp.add(candidates[j]);
            trackResult(candidates, j + 1, target - candidates[j], temp, result);
            int lastOut = candidates[j];
            temp.remove(temp.size() - 1);
            j++;
            while (j < candidates.length - 1 && candidates[j] == lastOut) j++;
        }
    }
}