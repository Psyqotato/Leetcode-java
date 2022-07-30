import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> newWords = Arrays.asList(s.split("\\s+"));
        Collections.reverse(newWords);
        return String.join(" ", newWords);
    }
}