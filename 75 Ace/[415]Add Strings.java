class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        int m = num1.length(), n = num2.length(), carry = 0;
        int digit1 = 0, digit2 = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            digit1 = (i <= m - 1)? num1.charAt(m - 1 - i) - '0' : 0;
            digit2 = (i <= n - 1)? num2.charAt(n - 1 - i) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}