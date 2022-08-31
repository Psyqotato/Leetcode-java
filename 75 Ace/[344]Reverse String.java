class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}