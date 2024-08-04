class Solution {
    public int min1(int [] nums,int k){
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=k)
                res+=Math.abs(nums[i]-k);
        }
        return res;
    }
    public int minMoves2(int[] nums) {
        int i = nums.length;
        Arrays.sort(nums);
        int mid ;
        if(i%2==1)  mid = nums[i/2];
        else mid = nums[i/2-1];
        // System.out.println(mid);
        int res = Math.min(min1(nums,mid),min1(nums,mid+1));
        return res;
    }
}