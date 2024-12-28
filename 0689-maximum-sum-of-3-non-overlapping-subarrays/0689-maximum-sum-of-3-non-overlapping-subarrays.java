class Solution {
    int dp[][];
    int pre[];
    // public 
    public int fm(int i,int c,int n,int k){
        if(c==3){
            return 0;
        }
        if(i+k>n){
            return 0;
        }
        if(dp[i][c]!=-1){
            return dp[i][c];
        }
        int pick = pre[i+k]-pre[i]+fm(i+k,c+1,n,k);
        int notpick = fm(i+1,c,n,k);

        return dp[i][c] = Math.max(pick,notpick);
    }
    public void f(int i,int c,int n,int k,List<Integer> res){
        if(c==3){
            return ;
        }
        if(i+k>n){
            return ;
        }
        int pick = fm(i+k,c+1,n,k)+pre[i+k]-pre[i];
        int np = fm(i+1,c,n,k);
        if(pick>=np){
            res.add(i);
            f(i+k,c+1,n,k,res);
        }
        else{
            f(i+1,c,n,k,res);
        }
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        pre = new int[n+1];
        for(int i=0;i<n;i++){
            // sum+=nums[i];
            pre[i+1] = pre[i]+nums[i];
        }
        dp = new int[n][3];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        fm(0,0,n,k);
        List<Integer> arr = new ArrayList<>();
        f(0,0,n,k,arr);
        int res[] = new int[3];
        res[0] = arr.get(0);
        res[1] = arr.get(1);
        res[2] = arr.get(2);
        return res;
    }
}