class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] chars = new int[128];
        for (char c : s.toCharArray()) chars[c]++;
        HashSet<Character> mySet = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            chars[c]--;
            mySet.add(c);
            if (chars[c] == 0 && validPartition(mySet, chars)) {
                result.add(right - left + 1);
                right++;
                left = right;
                mySet.clear();
            }else{
                right++;
            }
        }
        return result;
    }
    boolean validPartition(HashSet<Character> mySet, int[] chars) {
        for (char c : mySet) {
            if (chars[c] != 0) return false;
        }
        return true;
    }
}