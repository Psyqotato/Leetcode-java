class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] resultSplit = new String[numRows];
        Arrays.fill(resultSplit, "");
        int i = 0, j = 0;
        while (i < s.length()) {
            while (i < s.length() && j < numRows) {
                resultSplit[j] += s.charAt(i);
                i++;
                j++;
            }
            j = numRows - 2;
            while (i < s.length() && j >= 0) {
                resultSplit[j] += s.charAt(i);
                i++;
                j--;
            }
            j = 1;
        }
        return Arrays.stream(resultSplit).collect(Collectors.joining());
    }
}