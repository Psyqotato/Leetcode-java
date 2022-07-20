import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> result;
    LinkedList<String> validIp;
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        result = new LinkedList<>();
        validIp = new LinkedList<>();
        backTrack(s, validIp, 0, 1);
        return result;
    }
    public void backTrack(String s, LinkedList<String> vaildIp, int start, int k){
        if (k == 5 && start > s.length() - 1) {
            result.add(String.join(".", validIp));
            return;
        }
        int n = s.length();
        for (int i = start + 1; i <= n && i <= start + 3; i++) {
            if (n - i > (4 - k) * 3) continue;
            if (n - i < 4 - k) break;
            if (i > start + 1 && s.charAt(start) == '0') break;
            if (i == start + 3 && Integer.parseInt(s.substring(start, i)) > 255) break;
            validIp.add(s.substring(start, i));
            backTrack(s, vaildIp, i, k + 1);
            validIp.removeLast();
        }
    }
}