import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = oneMoreLetter(result, Character.getNumericValue(digits.charAt(i)));
        }
        return result;
    }

    List<String> oneMoreLetter(List<String> s, int num) {
        String[] str = new String[]{"", "", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        for (String strs : s) {
            for (int i = 0; i < str[num].length(); i++) {
                res.add(strs + str[num].substring(i,i+1));
            }
        }
        return res;
    }
}