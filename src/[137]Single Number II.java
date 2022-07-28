import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (myMap.get(num) == 1) return num;
        }
        return 0;
    }
}