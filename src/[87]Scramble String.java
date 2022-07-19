import java.sql.ClientInfoStatus;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, Integer> wholeMap;
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        wholeMap = new HashMap<String, Integer>();
        for (int i = 1; i < n; i++) {
            if ((isScram(s1.substring(0, i), s2.substring(0,i)) && isScram(s1.substring(i), s2.substring(i))) ||
                    (isScram(s1.substring(0,i), s2.substring(n - i)) && isScram(s1.substring(i), s2.substring(0, n - i))))
                return true;
        }
        return false;
    }

    public boolean isScram(String s1, String s2) {
        if (s1.equals(s2)) return true;
        String temp = s1 + s2;
        if (wholeMap.getOrDefault(temp, 0) == -1) return false;
        if (wholeMap.getOrDefault(temp, 0) == 1) return true;
        int n = s1.length();
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            myMap.put(s1.charAt(i), myMap.getOrDefault(s1.charAt(i), 0) + 1);
            myMap.put(s2.charAt(i), myMap.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (Integer value : myMap.values()) {
            wholeMap.put(temp, -1);
            if (value != 0) return false;
        }
        for (int i = 1; i < n; i++) {
            if ((isScram(s1.substring(0, i), s2.substring(0,i)) && isScram(s1.substring(i), s2.substring(i))) ||
                    (isScram(s1.substring(0,i), s2.substring(n - i)) && isScram(s1.substring(i), s2.substring(0, n - i)))) {
                wholeMap.put(temp, 1);
                return true;
            }
        }
        wholeMap.put(temp, -1);
        return false;
    }
}