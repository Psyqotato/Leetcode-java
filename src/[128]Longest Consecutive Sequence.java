import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int num : nums) mySet.add(num);

        int result = 0;
        for (int num : mySet) {
            int count = 1;
            if (!mySet.contains(num - 1)) {
                int begin = num + 1;
                while(mySet.contains(begin)) {
                    count++;
                    begin++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}