import java.util.ArrayList;
import java.util.List;

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] start = new int[n];
        List<Integer> positiveP = new ArrayList<>();
        int mini = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < n; i++) {
            start[i] = gas[i] - cost[i];
            total += start[i];
            if (start[i] >= 0 && gas[i] > 0) positiveP.add(i);
        }
        if (total < 0 || positiveP.size() == 0) return -1;
        int[] positiveR = new int[positiveP.size()];
        for (int i = 0; i < positiveP.size(); i++) {
            int j = (positiveP.get(i) == n - 1)? 0 : positiveP.get(i) + 1;
            positiveR[i] += start[positiveP.get(i)];
            while(j != positiveP.get(i) && start[j] <= 0) {
                positiveR[i] += start[j];
                j = (j == n - 1)? 0 : j + 1;
            }
        }
        for (int i = 0; i < positiveR.length; i++) {
            boolean flag = true;
            int j = i;
            int count = 0;
            int end = (j == 0)? positiveR.length - 1 : i - 1;
            while(j != end) {
                count += positiveR[j];
                if (count < 0) {
                    flag = false;
                    break;
                }
                j = (j == positiveR.length - 1)? 0 : j + 1;
            }
            if (flag) return positiveP.get(i);
        }
        return -1;
    }
}