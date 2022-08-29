class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            if (!mySet.add(num)) return true;
        }
        return false;
    }
}