class Solution {
    public int maxProduct(int[] nums) {
        int front = 1;
        int back = 1;
        int maxi = nums[0];
        for(int i=0;i<nums.length;i++){
            front = front*nums[i];
            maxi = Math.max(maxi,front);
            if(front==0)    front=1;
        }
        for(int i=nums.length-1;i>=0;i--){
            back = back*nums[i];
            maxi = Math.max(maxi,back);
            if(back==0) back=1;
        }
        for(int i=0;i<nums.length;i++){
            // front = front*nums[i];
            maxi = Math.max(maxi,nums[i]);
        }
        return maxi;

    }
}