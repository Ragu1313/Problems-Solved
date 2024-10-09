class Solution {
    public int longest(int i,int j,String s1,String s2,int [][]dp,int l1,int l2){
        //base case
        if(i>=l1 || j>=l2)  return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pick ;
        if(s1.charAt(i)==s2.charAt(j)){
            pick = 1+longest(i+1,j+1,s1,s2,dp,l1,l2);
            return dp[i][j] = pick;
        }
        else{
            pick =Math.max(longest(i+1,j,s1,s2,dp,l1,l2),longest(i,j+1,s1,s2,dp,l1,l2));
            return dp[i][j] = pick;
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int dp[][] = new int [l1][l2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return longest(0,0,text1,text2,dp,l1,l2);
    }
}