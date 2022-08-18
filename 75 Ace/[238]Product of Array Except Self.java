import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count = 0;
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            }else{
                count++;
                p = i;
            }
        }
        int[] result = new int[nums.length];
        if (count >= 2) {
            Arrays.fill(result, 0);
            return result;
        }
        if (count == 1) {
            Arrays.fill(result, 0);
            result[p] = product;
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[i] = product / nums[i];
            }else{
                nums[i] = 0;
            }
        }
        return result;
    }
}