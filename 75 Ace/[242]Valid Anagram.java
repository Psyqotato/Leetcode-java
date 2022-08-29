
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] strs = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            strs[s.charAt(i) - 'a']++;
            strs[t.charAt(i) - 'a']--;
        }
        for (int value : strs) {
            if (value != 0) return false;
        }
        return true;
    }
}