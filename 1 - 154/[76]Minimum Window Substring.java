import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, m = s.length(), n = t.length();
        if (s.equals(t)) return s;
        if (n > m) return "";
        String result = "";
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            myMap.put(t.charAt(i), myMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        if (myMap.containsKey(s.charAt(0))) myMap.put(s.charAt(0), myMap.get(s.charAt(0)) + 1);
        while (right <= m - 1) {
            while (right < m - 1 && !compareMap(myMap)) {
                if ((result.length() != 0 && right - left < result.length()) || result.length() == 0) {
                    right++;
                    if (myMap.containsKey(s.charAt(right))) {
                        myMap.put(s.charAt(right), myMap.get(s.charAt(right)) + 1);
                    }
                }else{
                    right++;
                    if (myMap.containsKey(s.charAt(right))) {
                        myMap.put(s.charAt(right), myMap.get(s.charAt(right)) + 1);
                    }
                    if (myMap.containsKey(s.charAt(left))) {
                        myMap.put(s.charAt(left), myMap.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
            }
            if (compareMap(myMap)) {
                if (result.length() == 0) result = s.substring(left, right + 1);
                if (result.length() > right - left) result = s.substring(left, right + 1);
            }
            while (left <= right && compareMap(myMap)) {
                result = (result.length() > right - left)? s.substring(left, right + 1) : result;
                if (myMap.containsKey(s.charAt(left))) {
                    myMap.put(s.charAt(left), myMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
            if (right - left > result.length() ||  (right == m - 1 && !compareMap(myMap))) break;
        }
        return result;
    }

    public boolean compareMap(HashMap<Character, Integer> myMap) {
        for (Integer value : myMap.values()) {
            if (value < 0) return false;
        }
        return true;
    }
}