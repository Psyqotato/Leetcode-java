
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        int l = 0, r = 0;
        StringBuilder strs = new StringBuilder(s);
        for (int i = 0; i < strs.length(); i++) {
            char c = strs.charAt(i);
            if (c == '(') {
                l++;
            }else if (c == ')'){
                r++;
            }
            if (r > l) {
                strs.setCharAt(i, '#');
                l = 0;
                r = 0;
            }
        }
        l = 0;
        r = 0;
        for (int i = strs.length() - 1; i >= 0; i--) {
            char c = strs.charAt(i);
            if (c == '(') {
                l++;
            }else if (c == ')'){
                r++;
            }
            if (l > r) {
                strs.setCharAt(i, '#');
                l = 0;
                r = 0;
            }
        }
        String result = strs.toString().replaceAll("#", "");
        return result;
    }
}