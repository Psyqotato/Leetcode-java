class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        int dividor = 5;
        while (n >= dividor) {
            result += n / dividor;
            dividor *= 5;
        }
        return result;
    }
}