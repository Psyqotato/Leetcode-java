class Solution {

    public int minCost(String colors, int[] neededTime) {
        char[] strs = colors.toCharArray();
        int left = 0, right = 0, result = 0;
        while (left < strs.length) {
            int max = neededTime[left];
            while (right < strs.length && strs[left] == strs[right]) {
                result += neededTime[right];
                max = Math.max(max, neededTime[right]);
                right++;
            }
            result -= max;
            left = right;
        }
        return result;
    }
}