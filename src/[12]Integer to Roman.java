class Solution {
    public String intToRoman(int num) {
        String[] sym = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";
        int i = 0;
        while (i < sym.length) {
            while (num - val[i] >= 0) {
                result += sym[i];
                num -= val[i];
            }
            i++;
        }
        return result;
    }
}