public class DemoApplication {

    LinkedList<List<Integer>> result;
    LinkedList<Integer> solution;
    boolean[] queens;
    public static void main(String[] args) {
        DemoApplication d = new DemoApplication();
        System.out.println(d.nQueens(6));
    }
    List<List<Integer>> nQueens(int n) {
        result = new LinkedList<>();
        solution = new LinkedList<>();
        queens = new boolean[n];
        backTrack(0, n);
        return result;
    }

    void backTrack(int i, int n){
        if (solution.size() == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (queens[j]) continue;
            if (validQueen(i, j)) {
                solution.add(j);
                queens[j] = true;
                backTrack(i + 1, n);
                queens[j] = false;
                solution.removeLast();
            }
        }
    }
    boolean validQueen(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (solution.get(k) - k == j - i || solution.get(k) - j == i - k) return false;
        }
        return true;
    }
}