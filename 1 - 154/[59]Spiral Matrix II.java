import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int[][] result = new int[n][n];
        int nums = 1;
        while (nums <= n * n) {

            if (up <= down){
                for (int i = left; i <= right; i++) {
                    result[up][i] = nums;
                    nums++;
                }
                up++;
            }

            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    result[i][right] = nums;
                    nums++;
                }
                right--;
            }

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result[down][i] = nums;
                    nums++;
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result[i][left] = nums;
                    nums++;
                }
                left++;
            }
        }
        return result;
    }
}