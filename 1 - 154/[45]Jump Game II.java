class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int i = 0, position = 0, count = 0;
        while (i < nums.length - 1 && nums[i] + i < nums.length - 1){
            position = i + 1;
            for (int jump = position + 1;jump <= i + nums[i];jump++) {
                if (nums[jump] + jump > nums[position] + position) position = jump;
            }
            i = position;
            count++;
        }
        return count + 1;
    }
}