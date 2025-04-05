class Solution {
    // List<Integer> arr = new ArrayList<>();
    int res = 0;
    public void f(int i,int n,int sum,int nums[]){
        if(i==n){
            res += sum;
            return ;
        }
        // if(dp[i]!=-1)
        //     return dp[i];
        f(i+1,n,sum^nums[i],nums);
        f(i+1,n,sum,nums);
        
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        f(0,n,0,nums);
        // System.out.println(arr);
        return res;
    }
}