class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        HashMap<Character, Integer> myMap = new HashMap<>();
//        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            myMap.put(p.charAt(i), myMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        while (right < s.length() + 1) {
            while (right < p.length()) {
                char charIn = s.charAt(right);
                if (myMap.containsKey(charIn)) myMap.put(charIn, myMap.get(charIn) - 1);
                right++;
            }
            if (validChar(myMap)) result.add(left);
            if (right < s.length()) {
                char charOut = s.charAt(left);
                char charIn = s.charAt(right);
                if (myMap.containsKey(charOut)) myMap.put(charOut, myMap.get(charOut) + 1);
                if (myMap.containsKey(charIn)) myMap.put(charIn, myMap.get(charIn) - 1);
            }
            left++;
            right++;
        }
        return result;
    }
    boolean validChar(HashMap<Character, Integer> myMap) {
        for (int value : myMap.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}