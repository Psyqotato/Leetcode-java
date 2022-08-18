
import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        nums.push(num);
                        break;
                    case '-':
                        nums.push(-num);
                        break;
                    case '*':
                        nums.push(nums.pop() * num);
                        break;
                    case '/':
                        nums.push(nums.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }
        return result;
    }
}