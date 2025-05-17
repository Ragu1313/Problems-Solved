class Solution {
    public void quicksort(int nums[],int low,int high){
        if(low>=high)
			 return ;
        int i = low;
        int j = high;
        int m = (high+low)/2;
        int pivot = nums[m];
        while(i<=j){
            while(nums[i]<pivot)
               i++;
            while(nums[j]>pivot)
               j--;
            if(i<=j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp; 
                i++;
                j--;
            }
        }
        quicksort(nums,low,j);
        quicksort(nums,i,high);
    }
    public void sortColors(int[] nums) {
        quicksort(nums,0,nums.length-1);
    }
}