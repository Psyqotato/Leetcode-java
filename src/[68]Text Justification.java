import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        List<String> oneLine = new ArrayList<>();
        int count = 0, i = 0;
        while (i < words.length) {
            while (i < words.length && maxWidth - count >= words[i].length()) {
                oneLine.add(words[i]);
                count += words[i].length() + 1;
                i++;
            }
            if (i == words.length || oneLine.size() == 1){
                result.add(leftJustify(oneLine, maxWidth, count - oneLine.size()));
            }else{
                result.add(justifyOneLine(oneLine, maxWidth, count - oneLine.size()));
            }
            count = 0;
            while (oneLine.size() != 0) oneLine.remove(0);
        }
        return result;
    }

    public String justifyOneLine(List<String> oneLine, int maxWidth, int count) {
        int m = maxWidth - count;
        int n = oneLine.size() - 1;
        int spaces = 0, after = 0;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append(oneLine.get(i));
            if (i < m % n) result.append(' ');
            for (int j = 0; j < m / n; j++) result.append(' ');
        }
        result.append(oneLine.get(oneLine.size() - 1));
        return result.toString();
    }

    public String leftJustify(List<String> oneLine, int maxWidth, int count) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < oneLine.size() - 1; i++) {
            result.append(oneLine.get(i));
            result.append(' ');
        }
        result.append(oneLine.get(oneLine.size() - 1));
        while (result.length() < maxWidth) result.append(' ');
        return result.toString();
    }
}