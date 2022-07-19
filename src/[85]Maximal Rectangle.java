import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0, height = 0;
        Deque<Integer> myStack = new ArrayDeque<>();
        myStack.push(-1);
        for (int i = 0; i < n; i++) {
            while (myStack.size() > 1 && heights[i] < heights[myStack.peek()]) {
                height = heights[myStack.pop()];
                result = Math.max(result, (i - myStack.peek() - 1) * height);
            }
            myStack.push(i);
        }
        while (myStack.peek() != -1) {
            height = heights[myStack.pop()];
            result = Math.max(result, (n - myStack.peek() - 1) * height);

        }
        return result;
    }
}