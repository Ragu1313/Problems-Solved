/*34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
Solution:
*/
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

