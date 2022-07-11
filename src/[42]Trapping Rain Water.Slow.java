class Solution {
    public int trap(int[] height) {
        int result = 0;
        int l = height[0], li = 0, r = 0, ri = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] > height[li]) {
                l = height[i];
                li = i;
            }
            int j = i + 1;
            if (i >= ri) {
                ri = j;
                while (j < height.length) {
                    if (height[j] >= height[ri]) {
                        ri = j;
                    }
                    j++;
                }
            }
            r = height[ri];
            result += Math.max(Math.min(l, r) - height[i], 0);
        }
        return result;
    }
}