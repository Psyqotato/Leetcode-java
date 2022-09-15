class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];
        int[] result = new int[n / 2];
        Arrays.sort(changed);
        int[] count = new int[changed[n - 1] + 1];
        for (int value : changed) {
            count[value]++;
        }
        int i = n - 1, j = 0;
        while (i >= 0) {
            while (i >= 0 && count[changed[i]] == 0) i--;
            if (i >= 0) {
                int num = changed[i];
                if (num % 2 != 0 || count[num / 2] == 0) {
                    return new int[0];
                }else{
                    result[j] = num / 2;
                    count[num]--;
                    count[num / 2]--;
                    i--;
                    j++;
                }
            }
        }
        return result;
    }
}