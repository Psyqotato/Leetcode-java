class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        String rex = "[^a-z0-9]";
        String[] s_split = s.split(rex);
        String result = String.join("", s.split(rex));
        for (int i = 0; i < result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - 1 - i)) return false;
        }
        return true;
    }
}