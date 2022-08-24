class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        int result = 0, oddCount = -1;
        for (int i = 0; i < s.length(); i++) {
            myMap.put(s.charAt(i), myMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int value : myMap.values()) {
            if (value % 2 != 0) {
                oddCount++;
            }
            result += value;
        }
        return (oddCount == -1)? result : result - oddCount;
    }
}