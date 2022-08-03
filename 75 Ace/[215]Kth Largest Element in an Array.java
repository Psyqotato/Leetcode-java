import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p < k) {
                low = p + 1;
            }else if (p > k) {
                high = p - 1;
            }else{
                return nums[p];
            }
        }
        return -1;
    }

    void quickSort(int[] nums, int low, int high) {
        if (low > high) return;

        int p = partition(nums, low, high);
        quickSort(nums, low, p + 1);
        quickSort(nums, p + 1, high);
    }

    int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while(i < high && nums[i] <= pivot) {
                i++;
            }
            while(j > low && nums[j] > pivot) {
                j--;
            }
            if (i >= j) break;
            swap(nums, i , j);
        }
        swap(nums, low, j);
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(nums, i, r);
        }
    }
}