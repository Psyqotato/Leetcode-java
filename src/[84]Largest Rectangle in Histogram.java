import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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