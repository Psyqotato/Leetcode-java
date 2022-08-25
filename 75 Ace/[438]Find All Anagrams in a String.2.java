class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s.length() + 1) {
            while (right < p.length()) {
                char charIn = s.charAt(right);
                if (p.contains(String.valueOf(charIn))) chars[charIn - 'a']--;
                right++;
            }
            if (validChar(chars)) result.add(left);
            if (right < s.length()) {
                char charOut = s.charAt(left);
                char charIn = s.charAt(right);
                if (p.contains(String.valueOf(charOut))) chars[charOut - 'a']++;
                if (p.contains(String.valueOf(charIn))) chars[charIn - 'a']--;
            }
            left++;
            right++;
        }
        return result;
    }
    boolean validChar(int[] chars) {
        for (int value : chars) {
            if (value != 0) return false;
        }
        return true;
    }
}