class Solution {
    public int bs(int tar,int nums[],int low,int high){
        // int low = 0;
        // int high = n-1;
        int res  =-1 ;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(tar>nums[mid]){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int sum = nums[i] + nums[j];
                int ind = bs(sum,nums,j+1,n-1);
                if(ind!=-1){
                    // System.out.println(ind-j+" "+nums[i]+" "+nums[j]);
                    res += (ind-j);
                }
            }
        }
        return res;
    }
}