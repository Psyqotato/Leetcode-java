import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> myStack;
    Stack<Integer> minStack;

    public MinStack() {
        myStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        myStack.push(val);
        if (minStack.peek() > val){
            minStack.push(val);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        myStack.pop();
        minStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}