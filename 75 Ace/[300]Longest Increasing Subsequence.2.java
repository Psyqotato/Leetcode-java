import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int[] topCard = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int card = nums[i];
            int left = 0, right = result;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (topCard[mid] >= card) {
                    right = mid;
                }else if (topCard[mid] < card){
                    left = mid + 1;
                }
            }
            if (left == result) result++;
            topCard[left] = card;
        }
        return result;
    }
}