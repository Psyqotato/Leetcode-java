class Solution {

    HashMap<String, List<List<String>>> myMap = new HashMap<>();
    HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();
    public List<List<String>> partition(String s) {
        if (myMap.get(s) != null) return new ArrayList<>(myMap.get(s));
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        if (isPalidrome(s)) {
            solution.add(s);
            result.add(new ArrayList<>(solution));
            solution.clear();
            if (s.length() == 1) {
                myMap.put(s, new ArrayList<>(result));
                return result;
            }
        }

        List<List<String>> leftStrings = new ArrayList<>();
        List<List<String>> rightStrings = new ArrayList<>();
        String left, right;
        for (int i = 1; i < s.length(); i++) {
            left = s.substring(0, i);
            right = s.substring(i);
            leftStrings = partition(left);
            rightStrings = partition(right);
            for (List<String> leftString : leftStrings) {
                for (List<String> rightString : rightStrings) {
                    solution.addAll(leftString);
                    solution.addAll(rightString);
                    result.add(new ArrayList<>(solution));
                    solution.clear();
                }
            }
            leftStrings.clear();
            rightStrings.clear();
        }
        myMap.put(s, new ArrayList<>(result));
        return result;
    }

    boolean isPalidrome (String str) {
        if (wordMap.get(str) != null) return wordMap.get(str);
        if (str.length() == 1) return true;
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                wordMap.put(str, false);
                return false;
            }
        }
        wordMap.put(str, true);
        return true;
    }
}