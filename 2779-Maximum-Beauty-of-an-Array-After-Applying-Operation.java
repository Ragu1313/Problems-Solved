class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(nums[i],maxi);
        }
        int arr[] = new int[maxi+k+2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]-k>0)
            arr[nums[i]-k]++;
            else{
                arr[0]++;
            }
            arr[nums[i]+k+1]--;
        }
        int res =0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            // System.out.println(arr[i]);
            sum = sum + arr[i];
            res = Math.max(sum,res);
        }
        return res;
    }
}