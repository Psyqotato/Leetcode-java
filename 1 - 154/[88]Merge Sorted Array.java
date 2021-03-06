class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n;
        while (m != 0 || n != 0) {
            if ((m!= 0 && n != 0 && nums1[m - 1] > nums2[n - 1]) || (n == 0 && m != 0)) {
                nums1[i - 1] = nums1[m - 1];
                m--;
                i--;
            }else if ((m != 0 && n != 0 && nums1[m - 1] <= nums2[n - 1]) || (m == 0 && n != 0)){
                nums1[i - 1] = nums2[n - 1];
                n--;
                i--;
            }
        }
    }
}