class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int lmax = 0, rmax = 0;
        while (left < right) {
            lmax = Math.max(height[left], lmax);
            rmax = Math.max(height[right], rmax);

            if (lmax < rmax) {
                result += lmax - height[left];
                left++;
            }else{
                result += rmax - height[right];
                right--;
            }
        }
        return result;
    }
}