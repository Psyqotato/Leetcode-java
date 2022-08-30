import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private class Pair {
        int val, index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private Pair[] temp;
    private int[] count;

    private void sort(Pair[]arr, int low, int high) {
        if (low == high) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(Pair[]arr, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int p = low, q = mid + 1;
        for (int i = low; i <= high; i++) {
            if (p == mid + 1) {
                arr[i] = temp[q++];
            }else if (q == high + 1) {
                arr[i] = temp[p++];
                count[arr[i].index] += q - mid - 1;
            }else if (temp[p].val > temp[q].val) {
                arr[i] = temp[q++];
            }else{
                arr[i] = temp[p++];
                count[arr[i].index] += q - mid - 1;
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        count = new int[n];
        temp = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        sort(arr, 0, n - 1);
        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }
}