/*
560. Subarray Sum Equals K
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int res = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            cnt = cnt+nums[i];
            int temp = cnt-k;
            // if(nums[i]==k && temp==k)  res++;
            if(map.containsKey(temp))  res+=map.get(temp);
            if(map.containsKey(cnt))   map.put(cnt,map.get(cnt)+1);
            else map.put(cnt,1);
        }
        return res;
    }
}