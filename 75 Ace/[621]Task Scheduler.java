class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> myMap = new HashMap<>();
        for (char c : tasks) {
            myMap.put(c, myMap.getOrDefault(c, 0) + 1);
        }
        int max = 0, nearMax = 0;
        for (int value : myMap.values()) {
            if (max < value) max = value;
        }
        for (int value : myMap.values()) {
            if (value == max) nearMax++;
        }
        return Math.max((max - 1) * (n + 1) + nearMax, tasks.length);
    }
}