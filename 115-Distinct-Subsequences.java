class Solution {
    public int f(int i,int j,String s1,String s2,int dp[][]){
        if(j<0){
            return 1;
        }
        if(i<0 ){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = f(i-1,j,s1,s2,dp) + f(i-1,j-1,s1,s2,dp);
        }
        else{
            return dp[i][j] = f(i-1,j,s1,s2,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return f(s.length()-1,t.length()-1,s,t,dp);
    }
}