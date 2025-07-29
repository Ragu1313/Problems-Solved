class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int minSum = arr[0];
        int curSum = arr[0];
        int curMax = arr[0];
        int curMin = arr[0];
        int totSum = arr[0];
        for(int i=1;i<arr.length;i++){
            totSum+=arr[i];
            curMin = Math.min(curMin+arr[i] , arr[i]);
            minSum = Math.min(curMin,minSum);
            curSum = Math.max(curSum+arr[i],arr[i]);
            curMax = Math.max(curMax,curSum);
        }
        if(curMax<0)  return curMax;
        return Math.max(curMax,totSum-minSum);
    }
}