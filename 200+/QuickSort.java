class QuickSort {

    void sort (int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        int p = partition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) i++;
            while (j > low && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void shuffle (int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }
}