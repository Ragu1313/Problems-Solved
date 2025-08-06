class Solution {
    public void f(int inx,int nums[],int res[] ){
        if(inx==nums.length) return ;
        int nextInd = bs(res,nums[inx]);
        res[nextInd] = nums[inx];
        f(inx+1,nums,res);
        return ;
    }

    public int bs(int res[],int key ){
        int left = 0;
        int right = res.length-1;
        int result = -1;
        while(left<=right){
            int mid = left + (right-left) / 2;
            if(res[mid]>=key){
                result  = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res,(int)(1e9) );
        f(0,nums,res);
        for(int i=0;i<n;i++){
            if(res[i]==(int)(1e9))  return i;
        }
        return n;
    }
}