import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            char charIn = s.charAt(right);
            right++;
            window.put(charIn, window.getOrDefault(charIn, 0) + 1);
            while (window.get(charIn) > 1) {
                char charOut = s.charAt(left);
                left++;
                window.put(charOut, window.get(charOut) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}