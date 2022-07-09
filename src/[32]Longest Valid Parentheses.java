class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }else{
                r++;
                if (r == l) {
                    result = Math.max(result, r * 2);
                }else if (r > l) {
                    l = 0; r = 0;
                }
            }
        }
        l = 0; r = 0;
        for (int i = s.length() -1; i >= 0; i--){
            if (s.charAt(i) == ')') {
                r++;
            }else{
                l++;
                if (l == r) {
                    result = Math.max(result, l * 2);
                }else if (l > r) {
                    l = 0; r = 0;
                }
            }
        }
        return result;
    }
}