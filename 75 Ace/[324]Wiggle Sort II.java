import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = new int[5001];
        for (int num : nums) arr[num]++;
        int p = 5000;

        for (int i = 1; i < n; i += 2) {
            while (arr[p] == 0) p--;
            nums[i] = p;
            arr[p]--;
        }
        for (int i = 0; i < n; i += 2) {
            while (arr[p] == 0) p--;
            nums[i] = p;
            arr[p]--;
        }
    }
}