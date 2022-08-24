import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStk = new Stack<>();
        Stack<Character> charStk = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }else if (c == '[' && num != 0) {
                numStk.push(num);
                num = 0;
                charStk.push(c);
            }else if (c == ']') {
                int k = numStk.pop();
                StringBuffer str = new StringBuffer();
                String res = "";
                while (charStk.peek() != '[') str.append(charStk.pop());
                str.reverse();
                charStk.pop();
                for (int j = 0; j < k; j++) {
                    for (int z = 0; z < str.length(); z++) {
                        charStk.push(str.charAt(z));
                    }
                }
            }else{
                charStk.push(c);
            }
        }
        StringBuffer result = new StringBuffer();
        while (!charStk.isEmpty()) result.append(charStk.pop());
        return result.reverse().toString();
    }
}