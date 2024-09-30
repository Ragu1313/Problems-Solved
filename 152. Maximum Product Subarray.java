/*
152. Maximum Product Subarray
Solved
Medium
Topics
Companies
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int front = 1;
        int back = 1;
        int maxi = nums[0];
        for(int i=0;i<nums.length;i++){
            front = front*nums[i];
            maxi = Math.max(maxi,front);
            if(front==0)    front=1;
        }
        for(int i=nums.length-1;i>=0;i--){
            back = back*nums[i];
            maxi = Math.max(maxi,back);
            if(back==0) back=1;
        }
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(maxi,nums[i]);
        }
        return maxi;

    }
}
