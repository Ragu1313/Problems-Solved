class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n<3) return true;
        int prev = 0;
        for(int i=1;i<n-1;i++){
            if(nums[i]<nums[i-1] && nums[i]<=nums[i+1]){
                prev = i;
            }
        }

        if(nums[n-2]>nums[n-1]) prev = n-1;
        int pre = -1;
        System.out.println(prev);
        for(int i=prev;i<prev+n;i++){
            int temp = i%n;
            if(nums[temp]<pre){
                return false;
            }
            pre = nums[temp];
        }
        return true;
    }
}