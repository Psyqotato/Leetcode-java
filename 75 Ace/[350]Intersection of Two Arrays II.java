import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        for (int num : nums1) count1[num]++;
        List<Integer> count = new ArrayList<>();
        for (int num : nums2) {
            if (count1[num] != 0) {
                count.add(num);
                count1[num]--;
            }
        }
        int[] result = new int[count.size()];
        for (int i = 0; i < count.size(); i++) result[i] = count.get(i);
        return result;
    }
}