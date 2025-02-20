
class Solution {
    public int minOperations(int[] nums) {
        int originalLength = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] distinctNums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            distinctNums[index++] = num;
        }
        Arrays.sort(distinctNums);

        int longestSubarray = 0;
        int right = 0;

        for (int left = 0; left < distinctNums.length; left++) {
            while (right < distinctNums.length && distinctNums[right] < distinctNums[left] + originalLength) {
                right++;
            }
            longestSubarray = Math.max(longestSubarray, right - left);
        }

        return originalLength - longestSubarray;
    }
}