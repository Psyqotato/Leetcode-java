import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<List<Integer>, Integer> myMap = new HashMap<List<Integer>, Integer>();
    boolean[] used;
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        used = new boolean[n];
        for (int i = 0; i < n - 1; i ++) {
            used[i] = true;
            for (int j = i + 1; j < n; j++) {
                used[j] = true;
                lineSize(points[i][0], points[i][1], points[j][0], points[j][1], points);
                used[j] = false;
            }
            used[i] = false;
        }
        int result = 0;
        for (int value : myMap.values()) result = Math.max(result, value);
        return result;
    }
    void lineSize(int x1, int y1, int x2, int y2, int[][] points) {
        int deltaX, deltaY, b;
        if (x1 == x2) {
            deltaX = 0;
            deltaY = 0;
            b = x1;
        }else if (y1 == y2) {
            deltaX = 1;
            deltaY = 0;
            b = y1;
        }else{
            deltaY = Math.abs(y1 - y2);
            deltaX = Math.abs(x1 - x2);
            int xyGCD = getGCD(deltaY, deltaX);
            deltaY = (deltaX * deltaY == (y1 - y2) * (x1 - x2))? deltaY / xyGCD : -deltaY / xyGCD;
            deltaX = deltaX / xyGCD;
            b = y1 * deltaX - deltaY * x1;
        }
        List<Integer> line = new ArrayList<>();
        line.add(deltaY);
        line.add(deltaX);
        line.add(b);
        if (myMap.get(line) != null) return;
        int count = 2;
        for (int i = 0; i < points.length; i++) {
            if (used[i] == true) continue;
            int x3 = points[i][0], y3 = points[i][1];
            if (x1 == x2) {
                if (x1 == x3) count++;
            }else{
                if (y3 * deltaX == deltaY * x3 + b) count++;
            }
        }
        myMap.put(line, count);
    }

    int getGCD(int a, int b) {
        return (b == 0)? a : getGCD(b, a % b);
    }
}