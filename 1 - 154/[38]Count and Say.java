class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String input = countAndSay(n - 1);
        String result = "";
        int i = input.length() - 1;
        while (i >= 0) {
            char c = input.charAt(i);
            int count = 1;
            i--;
            while (i >= 0 && c == input.charAt(i)) {
                count++;
                i--;
            }
            result = "" + count + c + result;
        }
        return result;
    }
}