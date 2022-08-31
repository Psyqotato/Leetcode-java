class Solution {

    int[] nums;
    int[] originalNums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.originalNums = new int[nums.length];
        System.arraycopy(nums, 0, originalNums, 0, nums.length);
    }

    public int[] reset() {
        return originalNums;
    }

    public int[] shuffle() {
        int[] shuffle = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            shuffle[i] = nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int rand = randInt(i, nums.length - 1);
            int temp = shuffle[i];
            shuffle[i] = shuffle[rand];
            shuffle[rand] = temp;
        }
        return shuffle;
    }

    int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}