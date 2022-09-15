public class DemoApplication {

    LinkedList<List<Integer>> result;
    LinkedList<Integer> solution;
    boolean[] column;
    boolean[] leftToRight;
    boolean[] rightToLeft;
    public static void main(String[] args) {
        DemoApplication d = new DemoApplication();
        System.out.println(d.nQueens(13));
    }
    List<List<Integer>> nQueens(int n) {
        result = new LinkedList<>();
        solution = new LinkedList<>();
        column = new boolean[n];
        leftToRight = new boolean[n * 2 - 1];
        rightToLeft = new boolean[n * 2 - 1];
        backTrack(0, n);
        return result;
    }

    void backTrack(int i, int n){
        if (solution.size() == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (column[j] || leftToRight[i - j + n - 1] || rightToLeft[i + j]) continue;
            solution.add(j);
            column[j] = true;
            leftToRight[i - j + n - 1] = true;
            rightToLeft[i + j] = true;
            backTrack(i + 1, n);
            rightToLeft[i + j] = false;
            leftToRight[i - j + n - 1] = false;
            column[j] = false;
            solution.removeLast();
        }
    }
}