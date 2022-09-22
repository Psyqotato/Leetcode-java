class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder(strs[i]).reverse().toString();
        }
        return String.join(" ", strs);
    }
}