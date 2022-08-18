import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stars = new ArrayDeque<Integer>();
        for (int star : asteroids) {
            boolean alive = true;
            while (alive && star < 0 && !stars.isEmpty() && stars.peekFirst() > 0) {
                alive = (-star > stars.peekFirst());
                if (stars.peekFirst() <= -star) stars.pollFirst();
            }
            if (alive) stars.push(star);
        }
        int[] result = new int[stars.size()];
        for (int i = stars.size() - 1; i >= 0; i--) {
            result[i] = stars.pollFirst();
        }
        return result;
    }
}