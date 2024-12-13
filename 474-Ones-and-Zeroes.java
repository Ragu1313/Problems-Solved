class Solution {
    public int f(int i,int m,int n,String s[],int dp[][][]){
        if(i==s.length || (m==0 && n==0)){
            return 0;
        }
        if(dp[i][m][n]!=-1){
            return dp[i][m][n];
        }
        String s1 = s[i];
        int zerocnt=0;
        int onecnt=0;
        for(char ch : s1.toCharArray()){
            if(ch=='1')
                onecnt++;
            else
                zerocnt++;   
        }
        int maxi = 0;
        if(onecnt<=n && m>=zerocnt){
            maxi  = 1+f(i+1,m-zerocnt,n-onecnt,s,dp);
        }
        maxi = Math.max(maxi,f(i+1,m,n,s,dp));
        return dp[i][m][n] = maxi;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length+1][m+1][n+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return f(0,m,n,strs,dp);
    }
}