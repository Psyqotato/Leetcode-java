class Solution {
    public int myAtoi(String s) {
        int flag = 1, result = 0, i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
            continue;
        }
        while (i < s.length()) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i+1 < s.length() && !Character.isDigit(s.charAt(i+1))) break;
                if (i+1 < s.length() && s.charAt(i) == '-') {
                    flag = -1;
                    result = Character.getNumericValue(s.charAt(i+1)) * -1;
                    i += 2;
                    continue;
                }
                i++;
                continue;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && Character.getNumericValue(s.charAt(i)) > 7)) return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && Character.getNumericValue(s.charAt(i)) > 8)) return Integer.MIN_VALUE;
                result = result * 10 + Character.getNumericValue(s.charAt(i)) * flag;
                i++;
            }
            break;
        }
        return result;
    }
}