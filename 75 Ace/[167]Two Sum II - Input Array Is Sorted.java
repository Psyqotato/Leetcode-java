class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        while (left < right && sum != target) {
            if (sum > target) {
                right--;
            }else if (sum < target) {
                left++;
            }
            sum = numbers[left] + numbers[right];
        }
        return new int[]{left + 1, right + 1};
    }
}