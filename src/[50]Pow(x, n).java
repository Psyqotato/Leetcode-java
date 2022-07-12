class Solution {
    public double myPow(double x, int n) {
        return (n < 0)? 1 /  (x * myPower(x, 0 - n - 1)) : x * myPower(x, n - 1);
    }
    public double myPower (double x, int n) {
        if (n == -1) return 1 / x;
        if (n == 0) return 1.0;
        if (x == 1.0) return x;
        if (n == 1) return x;
        if (n % 2 == 0) {
            double x_double = myPower(x, n / 2);
            return x_double * x_double;
        }else{
            return x * myPower(x, n - 1);
        }
    }
}