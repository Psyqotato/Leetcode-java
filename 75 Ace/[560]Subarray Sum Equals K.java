import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        int result = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, 1);

        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (myMap.containsKey(preSum[i] - k)) {
                result += myMap.get(preSum[i] - k);
            }
            myMap.put(preSum[i], myMap.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }
}