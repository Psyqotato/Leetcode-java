import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> solution = new LinkedList<>();
        solution.add(1);
        if (rowIndex == 0) return solution;
        List<Integer> lastSolution = getRow(rowIndex - 1);
        for (int i = 1; i <= lastSolution.size() - 1; i++) {
            solution.add(lastSolution.get(i - 1) + lastSolution.get(i));
        }
        solution.add(1);
        return solution;
    }
}