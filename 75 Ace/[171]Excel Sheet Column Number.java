class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int n = columnTitle.length() - 1;
        for (int i = n; i >= 0; i--) {
            int c = columnTitle.charAt(i) - 'A' + 1;
            result += Math.pow(26, (n - i)) * c;
        }
        return result;
    }
}