class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxi=0;
        for(int i:nums){
            maxi = Math.max(i,maxi);
        }
        int arr[] = new int[maxi+k+2];
        for(int i : nums){
            if(i-k>0)
            arr[i-k]++;
            else{
                arr[0]++;
            }
            arr[i+k+1]--;
        }
        int res =0;
        int sum = 0;
        for(int i:arr){
            // System.out.println(arr[i]);
            sum = sum + i;
            res = Math.max(sum,res);
        }
        return res;
    }
}