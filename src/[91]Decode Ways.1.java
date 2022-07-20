import sun.awt.image.ImageWatched;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;
    int[] after;
    public int numDecodings(String s) {
        List<String> strs = Arrays.asList(s.split(""));
        List<Integer> nums = new LinkedList<>();
        for (int i = strs.size() - 1; i >= 0; i--) {
            while (i >= 0 && strs.get(i).equals("0")) {
                if ((i == 0 || (Integer.valueOf(strs.get(i - 1)) > 2 || Integer.valueOf(strs.get(i - 1)) == 0))) return 0;
                nums.add(Integer.valueOf(strs.get(i - 1)) * 10);
                i = i - 2;
            }
            if (i >= 0 ) nums.add(Integer.valueOf(strs.get(i)));
        }
        Collections.reverse(nums);
        after = new int[nums.size()];
        backTrack(nums, 0);
        return result;
    }

    public void backTrack(List<Integer> nums, int j) {
        if (j > 0 && after[j - 1] != 0) {
            result += after[j - 1];
            return;
        }
        if (j == nums.size()){
            result++;
            return;
        }
        backTrack(nums, j + 1);
        after[j] = result;
        if (j < nums.size() - 1 && (nums.get(j) == 1 && nums.get(j + 1) <= 9 || (nums.get(j) == 2 && nums.get(j + 1) <= 6))) {
            j++;
            backTrack(nums, j + 1);
        }
    }
}