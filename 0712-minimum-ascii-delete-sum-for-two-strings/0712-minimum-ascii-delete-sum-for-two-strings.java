class Solution {
    public int f(String s1,String s2,int i,int j,int dp[][]){
        if(i<0){
            int res = 0;
            for(int i1=j;i1>=0;i1--){
                res+=(int)s2.charAt(i1);
            }
            return res;
        }
        if(j<0){
            int res = 0;
            for(int ii=i;ii>=0;ii--){
                res+=(int)s1.charAt(ii);
            }
            return res;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = f(s1,s2,i-1,j-1,dp);
        }
        else{
            int first = (int)s1.charAt(i)+f(s1,s2,i-1,j,dp);
            int second = (int)s2.charAt(j)+f(s1,s2,i,j-1,dp);
            return dp[i][j] = Math.min(first,second);
        }

    }
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n][n2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return f(s1,s2,n-1,n2-1,dp);
    }
}