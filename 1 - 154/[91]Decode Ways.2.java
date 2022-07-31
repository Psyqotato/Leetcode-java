
import sun.awt.image.ImageWatched;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        result[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && (s.charAt(i + 1) - '0') <= 6))) {
                result[i] += result[i + 2];
            }
            result[i] += result[i + 1];
        }
        return result[0];
    }
}