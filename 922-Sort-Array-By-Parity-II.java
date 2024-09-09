class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n/2];
        int arr1[] = new int[n/2];
        int c = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)
                arr[c++] = nums[i];
        }
        
        c = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1)
                arr1[c++] = nums[i];
        }
        c = 0;
        for(int i = 0;i<n;i=i+2){
            nums[i] = arr[c++] ;
        }
        c = 0;
        for(int i = 1;i<n;i=i+2){
            nums[i] = arr1[c++] ;
        }

        return nums;
    }
}