class Solution {

    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int ind = n;
        int prev = 0;
        for(int i=n-1;i>=0;i--){
            if(prev<=nums[i]){
                prev = nums[i];
            }
            else{
                ind = i;break;
            }
        }
        if(ind==n){
            int i = 0;
            int j = n-1;
            while(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }
            return ;
        }
        int cnt[] = new int[101];
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                for(int j=ind+1;j<n;j++){
                    cnt[nums[j]]++;
                }
                int j = ind+1;
                int poi = 0;
                while(j<n){
                    while(cnt[poi]==0){
                        poi++;
                    }
                    nums[j] = poi;
                    cnt[poi]--;
                    j++;
                }
                return ;
            }
            
        }
    }

}