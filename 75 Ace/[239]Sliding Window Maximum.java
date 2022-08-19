import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        SingelQueue maxQueue = new SingelQueue();
        while (i < nums.length) {
            if (i < k - 1) {
                maxQueue.push(nums[i]);
            }else{
                maxQueue.push(nums[i]);
                result[i - k + 1] = maxQueue.getMax();
                maxQueue.pop(nums[i - k + 1]);
            }
            i++;
        }
        return result;
    }
}

class SingelQueue {
    private LinkedList<Integer> maxQueue = new LinkedList<>();
    public void push(int n) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < n) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(n);
    }
    public int getMax(){
        return maxQueue.peekFirst();
    }
    public void pop(int n) {
        if (maxQueue.peekFirst() == n) maxQueue.pollFirst();
    }
}