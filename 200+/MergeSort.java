class Merge {

	int[] temp;
	void sort (int[] nums) {
		temp = new int[nums.length];
		sort(nums, 0, nums.length - 1);
	}

	void sort(int[] nums, int low, int high) {
		if (low == high) return;
		int mid = low + (high - low) / 2;
		sort(nums, low, mid);
		sort(nums, mid + 1, high);
		merge(nums, low, mid, high);
	}

	void merge(int[] nums, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			temp[i] = nums[i];
		}

		int i = low, j = mid + 1;
		for (int p = low; p <= high; p++) {
			if (i == mid + 1) {
				nums[p] = temp[j++];
			}else if (j == high + 1) {
				nums[p] = temp[i++];
			}else if (temp[i] > temp[j]) {
				nums[p] = temp[j++];
			}else{
				nums[p] = temp[i++];
			}
		}
	}
}