import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited, memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        visited = new boolean[nums.length + 1];
        memo = new boolean[sum / 2 + 1];
        return dp(nums, sum / 2);
    }
    boolean dp(int[] nums, int amount) {
        if (amount < 0) return false;
        if (amount == 0) return true;
        if (memo[amount]) return false;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dp(nums, amount - nums[i])) return true;
            visited[i] = false;
        }
        memo[amount] = true;
        return false;
    }
}