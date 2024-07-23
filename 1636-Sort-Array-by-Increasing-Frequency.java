class Solution {
     public static void quicksort(int low, int high, int[] start, int[] end) {
        if (low >= high)
            return;
        int i = low;
        int j = high;
        int mid = i + (j - i) / 2;
        int pivot = end[mid];
        while (i <= j) {
           while (end[i] < pivot || (end[i] == pivot && start[i] > start[mid])) {
                i++;
            }
            while (end[j] > pivot || (end[j] == pivot && start[j] < start[mid])) {
                j--;
            }
            if (i <= j) {
                int temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                temp = start[i];
                start[i] = start[j];
                start[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksort(low, j, start, end);
        }
        if (i < high) {
            quicksort(i, high, start, end);
        }
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            a.put(nums[i], a.getOrDefault(nums[i], 0) + 1);
        }
        int[] freq = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            freq[i] = a.get(nums[i]);
        }
        // quicksort(0, nums.length - 1, nums, arr);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 ; j++) {
                // Check if swapping is needed
                if (freq[j] > freq[j + 1] || (freq[j] == freq[j + 1] && nums[j] < nums[j + 1])) {
                    // Swap frequencies
                    int tempFreq = freq[j];
                    freq[j] = freq[j + 1];
                    freq[j + 1] = tempFreq;

                    // Swap numbers
                    int tempNum = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tempNum;
                }
            }
        }
        return nums;
    }

}