import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> myMap = new HashMap<>();
        HashSet<String> mySet = new HashSet<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = strs[i];
            if (!myMap.containsKey(c) && !mySet.contains(word)) {
                myMap.put(c, strs[i]);
                mySet.add(word);
            }else if (myMap.containsKey(c) && mySet.contains(word)){
                if (!strs[i].equals(myMap.get(c))) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}