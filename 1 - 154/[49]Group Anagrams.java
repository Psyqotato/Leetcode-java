import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> count = new HashMap<>();
        for (String str : strs) {
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String strTemp = new String(charArray);
            count.putIfAbsent(strTemp, new LinkedList<>());
            count.get(strTemp).add(str);
        }
        for (List<String> value : count.values()) {
            result.add(value);
        }
        return result;
    }
}