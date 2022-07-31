class Solution {
    public int romanToInt(String s) {
        String[] sym = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int result = 0;
        int i = 0;
        while (i < sym.length) {
            while (s.contains(sym[i]) && s.charAt(0) == sym[i].charAt(0)) {
                result += val[i];
                s = s.substring(sym[i].length());
            }
            i++;
        }
        return result;
    }
}