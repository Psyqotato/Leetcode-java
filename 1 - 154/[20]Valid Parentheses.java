class Solution {
    public boolean isValid(String s) {
        Stack<Character> stacky = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == '(' || c == '[' || c == '{')) {
                stacky.push(c);
            }else if (!stacky.isEmpty() && reverseChar(c) == stacky.peek()){
                stacky.pop();
            }else{
                return false;
            }
        }
        return (stacky.isEmpty());
    }

    char reverseChar(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }
}