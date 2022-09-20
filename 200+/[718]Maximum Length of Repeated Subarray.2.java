class Solution {
    int[] nums1, nums2;
    public int findLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int m = nums1.length, n = nums2.length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            result = Math.max(result, findLenth(i, 0, Math.min(m - i, n)));
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, findLenth(0, i, Math.min(n - i, m)));
        }
        return result;
    }

    int findLenth(int start1, int start2, int len) {
        int result = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                count++;
            }else{
                count = 0;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}