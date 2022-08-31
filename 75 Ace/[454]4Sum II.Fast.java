class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int result = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                myMap.put(a + b, myMap.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                result += myMap.getOrDefault(-c-d, 0);
            }
        }
        return result;
    }
}