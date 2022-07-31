import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> notHappy = new HashSet<>();
        while (!notHappy.contains(n)) {
            notHappy.add(n);
            n = replaceNumber(n);
            if (n == 1) return true;
        }
        return false;
    }
    int replaceNumber(int n) {
        int sum = 0;
        while(n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}