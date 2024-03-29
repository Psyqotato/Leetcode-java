class Solution {

    int result;
    boolean[] column;
    boolean[] leftToRight;
    boolean[] rightToLeft;

    public int totalNQueens(int n) {
        result = 0;
        column = new boolean[n];
        leftToRight = new boolean[n * 2 - 1];
        rightToLeft = new boolean[n * 2 - 1];
        backTrack(0, n);
        return result;
    }

    void backTrack(int i, int n){
        if (i == n) {
            result++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (column[j] || leftToRight[i - j + n - 1] || rightToLeft[i + j]) continue;
            column[j] = true;
            leftToRight[i - j + n - 1] = true;
            rightToLeft[i + j] = true;
            backTrack(i + 1, n);
            rightToLeft[i + j] = false;
            leftToRight[i - j + n - 1] = false;
            column[j] = false;
        }
    }
}