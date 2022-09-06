class Solution {
    HashSet<Integer> res;
    int[] solution;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new HashSet();
        solution = new int[n];
        Arrays.fill(solution, -1);
        for (int i = 1; i <= 9; i++) {
            if (i + k < 10) {
                solution[0] = i;
                buildNumber(i, n, k, 1);
                solution[0] = -1;
            }
            if (i - k >= 0) {
                solution[0] = i;
                buildNumber(i, n, k, 1);
                solution[0] = -1;
            }
        }
        int[] result = new int[res.size()];
        Iterator<Integer> it = res.iterator();
        for (int i = 0; i < res.size(); i++) {
            result[i] = it.next();
        }
        return result;
    }
    void buildNumber(int i, int n, int k, int p) {
        if (p == n) {
            int sum = 0;
            for (int value : solution) sum = sum * 10 + value;
            res.add(sum);
            return;
        }
        if (i + k < 10) {
            solution[p] = i + k;
            buildNumber(i + k, n, k, p + 1);
            solution[p] = -1;
        }
        if (i - k >= 0) {
            solution[p] = i - k;
            buildNumber(i - k, n, k, p + 1);
            solution[p] = -1;
        }
    }
}