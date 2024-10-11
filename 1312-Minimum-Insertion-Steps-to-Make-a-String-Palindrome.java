class Solution {
    public int min(int i,int j,String s,int dp[][]){
        if(i>j) return 0;
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if(dp[i][j]!=-1)    return dp[i][j];
        if(ch1==ch2)   return dp[i][j] =  min(i+1,j-1,s,dp);
        else{
            int l = 1+min(i+1,j,s,dp);
            int r = 1+min(i,j-1,s,dp);
            return dp[i][j] = Math.min(l,r);
        } 
    }
    public int minInsertions(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return min(0,s.length()-1,s,dp);
    }
}