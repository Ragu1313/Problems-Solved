/*
215. Kth Largest Element in an Array
Solved
Medium
Topics
Companies

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 

Constraints:

    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104


*/
class Solution {
    public void heapify(int arr[],int i,int n){
        int largest = i;
        int left = (i*2)+1;
        int right = (i*2)+2;
        if(left<n && arr[left]>arr[largest])
            largest = left;
        if(right<n && arr[right]>arr[largest])
            largest = right;
        if(i!=largest){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr,largest,n);
        }
    }
    public int heapsort(int arr[],int k){
        int n = arr.length;
        for(int i = n/2-1;i>=0;i--)
            heapify(arr,i,n);
        for(int i = n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            if(--k==0){
                return arr[i];
            }
            heapify(arr,0,i);
        }
        return -1;
    }
    public int findKthLargest(int[] nums, int k) {
        return heapsort(nums,k);
    }
}

