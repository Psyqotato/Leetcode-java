class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) return result;
                if (strs[0].charAt(i) != strs[j].charAt(i)) return result;
            }
            result = strs[0].substring(0,i+1);
        }
        return result;
    }
}