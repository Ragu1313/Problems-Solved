class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int arr[] = new int[n+1];
        for(int i[] : queries){
            arr[i[0]]++;
            arr[i[1]+1]--;
        }
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(nums[i]>sum) return false;
        }
        return true;
    }
}