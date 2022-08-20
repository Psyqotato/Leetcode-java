
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {

        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.poll();
        }else if( large.size() > small.size()) {
            return large.poll();
        }
        return (small.poll() + large.poll()) / 2;
    }
}