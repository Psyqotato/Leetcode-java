class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, result = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                result = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }
}