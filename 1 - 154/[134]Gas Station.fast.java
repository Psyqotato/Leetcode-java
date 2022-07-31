class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int totalMin = Integer.MAX_VALUE;
        int minP = -1;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (totalMin > total) {
                totalMin = total;
                minP = i;
            }
        }
        if (total < 0) return -1;
        return (minP == n - 1)? 0 : minP + 1;
    }
}