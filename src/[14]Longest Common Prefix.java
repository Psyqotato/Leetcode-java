class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            result = strs[0].substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length()) return result.substring(0,i-1);
                if (!result.equals(strs[j].substring(0,i))) return result.substring(0,i-1);
            }
        }
        return result;
    }
}