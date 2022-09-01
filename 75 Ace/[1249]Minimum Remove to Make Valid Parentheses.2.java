class Solution {
    public String minRemoveToMakeValid(String s) {
        int l = 0, r = 0;
        StringBuilder strs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = strs.charAt(i);
            if (c == '(') {
                l++;
            }else if (c == ')'){
                r++;
            }
            if (r > l) {
                l = r = 0;
            }else{
                strs.append(c);
            }
        }
        l = r = 0;
        s = strs.toString();
        strs = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = strs.charAt(i);
            if (c == '(') {
                l++;
            }else if (c == ')'){
                r++;
            }
            if (l > r) {
                l = r = 0;
            }else{
                strs.append(c);
            }
        }
        return strs.reverse().toString();
    }
}