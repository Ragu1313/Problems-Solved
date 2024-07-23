import java.util.Arrays;

class Solution {
    public static int binarysearch(int low, int high, int[] arr, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] == target && (mid == 0 || arr[mid - 1] < target)) {
            return mid;
        }
        if (arr[mid] >= target) {
            return binarysearch(low, mid - 1, arr, target);
        } else {
            return binarysearch(mid + 1, high, arr, target);
        }
    }

    public static int binarysearch1(int low, int high, int[] arr, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] == target && (mid == arr.length - 1 || arr[mid + 1] > target)) {
            return mid;
        }
        if (arr[mid] <= target) {
            return binarysearch1(mid + 1, high, arr, target);
        } else {
            return binarysearch1(low, mid - 1, arr, target);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] num = new int[2];
        Arrays.fill(num, -1);
        if (nums.length == 0) {
            return num;
        }
        num[0] = binarysearch(0, nums.length - 1, nums, target);
        num[1] = binarysearch1(0, nums.length - 1, nums, target);
        return num;
    }
}
