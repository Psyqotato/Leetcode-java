class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0, end = 0;
        while(i < s.length()) {
            end = (i + k <= s.length())? i + k : s.length();
            sb.append(new StringBuilder(s.substring(i, end)).reverse().toString());
            i += k;
            if (i < s.length()) {
                end = (i + k < s.length())? i + k : s.length();
                sb.append(s.substring(i, end));
            }
            i += k;
        }
        return sb.toString();
    }
}