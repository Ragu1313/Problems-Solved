class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int arr[] = new int[100002];
        for(int i[] : queries){
            arr[i[0]]++;
            arr[i[1]+1]--;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=arr[i];
            if(nums[i]>sum) return false;
        }
        return true;
    }
}