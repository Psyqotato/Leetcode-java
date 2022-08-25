import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)] = i;
        }
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, chars[s.charAt(i)]);
            count++;
            if (i == max) {
                result.add(count);
                max = 0;
                count = 0;
            }
        }
        return result;
    }
}