import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStacky = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int a = myStacky.pop();
                int b = myStacky.pop();
                switch (token) {
                    case "+" : {
                        myStacky.push(a + b);
                        break;
                    }
                    case "-" : {
                        myStacky.push(b - a);
                        break;
                    }
                    case "*" : {
                        myStacky.push(a * b);
                        break;
                    }
                    case "/" : {
                        myStacky.push(b / a);
                        break;
                    }
                }
            }else{
                myStacky.push(Integer.parseInt(token));
            }
        }
        return myStacky.pop();
    }
}