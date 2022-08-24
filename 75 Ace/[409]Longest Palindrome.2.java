import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        char[] myChar = new char[123];
        int result = 0, oddCount = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            myChar[c]++;
        }
        for (int value : myChar) {
            if (value % 2 != 0) {
                oddCount++;
            }
            result += value;
        }
        return (oddCount == -1)? result : result - oddCount;
    }
}