import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (numRows < 1) return result;
        List<Integer> solution = new LinkedList<>();
        solution.add(1);
        result.add(solution);
        for (int i = 2; i <= numRows; i++) {
            result.add(new ArrayList<>(generateOne(result.getLast(), i)));
        }
        return result;
    }
    public List<Integer> generateOne(List<Integer> lastOne, int i) {
        List<Integer> newOne = new LinkedList<>();
        newOne.add(1);
        for (int j = 1; j < i - 1; j++) {
            newOne.add(lastOne.get(j - 1) + lastOne.get(j));
        }
        newOne.add(1);
        return newOne;
    }
}