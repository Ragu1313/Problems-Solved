class Solution {
    public int jump(int[] nums) {
        int i=1,index=nums[0],res=1;
        int l = nums.length;
        int prev=-1;
        // index = 0;
        // i=1;
        if(l==1)
            return 0;
        if(index>=l-1)
            return res;
        while(i<l){
            if(i+nums[i]>index){
                while(i<=index){
                    prev=Math.max(prev,i+nums[i]);
                    i++;
                }
                if(index<prev){
                    index=prev;
                    res++;
                }
            }
            else
                i++;
            if(index>=l-1)
                return res;
        }
        return res;
    }
}