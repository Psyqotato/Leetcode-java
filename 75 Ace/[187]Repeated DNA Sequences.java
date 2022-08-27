import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();

        int stringCode = 0;
        int R = 4;
        int L = 9;
        int RL = (int)Math.pow(4, 9);
        for (int i = 0; i < 10; i++) {
            stringCode = stringCode * R + getNumber(s.charAt(i));
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        seen.add(stringCode);
        int left = 0, right = 10;
        while (right < s.length()) {
            stringCode %= RL;
            stringCode *= R;
            stringCode += getNumber(s.charAt(right));
            left++;
            right++;
            if (seen.contains(stringCode)) {
                result.add(s.substring(left, right));
            }else{
                seen.add(stringCode);
            }
        }
        return new ArrayList<>(result);
    }
    public int getNumber(char c) {
        switch (c) {
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
        }
        return -1;
    }
}