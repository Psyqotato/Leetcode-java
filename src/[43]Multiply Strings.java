class Solution {
    public String multiply(String num1, String num2) {
        int num1l = num1.length(), num2l = num2.length();
        int[] result = new int[num1l + num2l];

        for (int i = num1l - 1; i >= 0; i--) {
            for (int j = num2l - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int position_1 = i + j, position_2 = i + j + 1;
                int sum = mul + result[position_2];
                result[position_1] = result[position_1] + sum / 10;
                result[position_2] = sum % 10;
            }
        }

        int k = 0;
        while (k < result.length && result[k] == 0) k++;
        String res = "";
        for(int i = k; i < result.length; i++) {
            res += result[i];
        }
        return (res.length() == 0) ? "0" : res;
    }
}