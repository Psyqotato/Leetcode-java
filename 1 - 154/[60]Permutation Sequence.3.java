import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        List<Integer> strs = new ArrayList<>();
        List<String> result = new ArrayList<>();
        k = k - 1;
        for (int i = 1; i <= n; i++) strs.add(i);
        for (int i = 0; i < n; i++) {
            int j = k / factorial[n - i - 1];
            result.add(strs.get(j).toString());
            k = k % factorial[n - i - 1];
            strs.remove(strs.indexOf(strs.get(j)));
        }
        String res = String.join("", result);
        return res;
    }
}