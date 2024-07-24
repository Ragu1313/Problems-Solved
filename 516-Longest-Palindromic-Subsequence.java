class Solution {
    public int longest(int i,int j , String s1,String s2,int l,int [][] dp){
        if(i>l || j>l)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j] = 1+longest(i+1,j+1,s1,s2,l,dp);
        else
            return dp[i][j] = Math.max(longest(i+1,j,s1,s2,l,dp),longest(i,j+1,s1,s2,l,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String s2 = \\;
        for(int i=s.length()-1;i>=0;i--){
            s2+=String.valueOf(s.charAt(i));
        }
        int dp[][]  = new int[s.length()][s.length()];
        // System.out.println(s2);
        for(int [] i:dp)
            Arrays.fill(i,-1);
        return longest(0,0,s,s2,s.length()-1,dp);
    }
}