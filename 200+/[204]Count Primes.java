import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < n; j += i) isPrime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}