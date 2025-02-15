class Solution {

    public boolean fun(int i,int j,String s1,String p,int dp[][]){

        if(i<0 && j<0){
            return true;
        }

        if(i>=0 && j<0)
            return false;

        if(j>=0 && i<0){
            for(int k = 0;k<=j;k++){
                if(p.charAt(k)!='*')    return false;
            }
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        char ch = s1.charAt(i);
        char t = p.charAt(j);
        if(ch==t || t=='?'){
            dp[i][j] = fun(i-1,j-1,s1,p,dp)?1:0;
            return dp[i][j]==1;
        }

        if(t=='*'){
            dp[i][j] = fun(i-1,j,s1,p,dp)||fun(i,j-1,s1,p,dp)?1:0;
            return dp[i][j]==1;
        }
        dp[i][j] = 0;
        return false;
    }

    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return fun(s.length()-1,p.length()-1,s,p,dp);
    }
}