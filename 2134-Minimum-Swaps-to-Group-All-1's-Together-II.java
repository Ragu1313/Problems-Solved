class Solution {
    public int minSwaps(int[] nums) {
        int c=0;
        int temp=0;
        int ans=nums.length;
        
        if(ans==1 || ans==0)
            return 0;
        int arr[] = new int [2*nums.length];
        for(c=0;c<arr.length;c++){
            arr[c] = nums[c%ans];
            // System.out.print(arr[c]+" ");
        }    
        c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                c++;
        }   
        // int start;
        int i=0,j=c;
        temp=0;
        for(i=0;i<c;i++){
            if(nums[i]==0)
                temp++;
        }     
        ans = temp;         
        for(i=1;i<=arr.length-c;i++){
            if(arr[j]==0)
                temp++;
            if(arr[i-1]==0)
                temp--;
            j++;
            ans = Math.min(ans,temp);
        }   
        return ans;                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    }
}