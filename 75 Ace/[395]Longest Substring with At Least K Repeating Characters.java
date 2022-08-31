class Solution {
    int[] count;
    public int longestSubstring(String s, int k) {
        int result = 0;
        for (int i = 1; i < 26; i++) {
            result = Math.max(result, longestSubstring(s, k, i));
        }
        return result;
    }

    public int longestSubstring(String s, int k, int charLimit) {
        int[] count = new int[26];
        int left = 0, right = 0;
        int charCount = 0, validCount = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            count[c - 'a']++;
            if (count[c - 'a'] == 1) charCount++;
            if (count[c - 'a'] == k) validCount++;
            right++;
            while (charCount > charLimit) {
                char cOut = s.charAt(left);
                if (count[cOut - 'a'] == k) validCount--;
                if (count[cOut - 'a'] == 1) charCount--;
                count[cOut - 'a']--;
                left++;
            }
            if (validCount == charLimit) {
                result = Math.max(result, right - left);
            }
        }
        return result;
    }
}