class Solution {
    public int[][] divideArray(int[] nums, int k) {
       int n = nums.length;
       int n1 = n/3;
       Arrays.sort(nums);
       int res[][] = new int[n1][3];
       int cnt = 0;
       for(int i=0;i+2<n;i+=3){
           if(nums[i+2] - nums[i] <=k){
                res[cnt][0] = nums[i];
                res[cnt][1] = nums[i+1];
                res[cnt][2] = nums[i+2];
                cnt++;
           }
           else return new int[0][0];
       } 
       return res;
    }
}