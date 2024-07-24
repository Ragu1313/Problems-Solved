class Solution {
    public int longest(int i,int j,String s1,String s2,int [][]dp,int l1,int l2){
        if(i>l1 || j>l2)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int take = 0;
        int nottake =0;
        if(s1.charAt(i)==s2.charAt(j))
            take =1+ longest(i+1,j+1,s1,s2,dp,l1,l2);
        else
            nottake = Math.max(longest(i,j+1,s1,s2,dp,l1,l2),longest(i+1,j,s1,s2,dp,l1,l2));
        return dp[i][j] = Math.max(take,nottake);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        if(l1>l2){
        int [][] dp = new int [l2][l1];
        for(int [] i:dp){
            Arrays.fill(i,-1);
        }
            return longest(0,0,text2,text1,dp,l2-1,l1-1);  
        }else{
          int [][] dp = new int [l1][l2];
        for(int [] i:dp){
            Arrays.fill(i,-1);
        }
         return longest(0,0,text1,text2,dp,l1-1,l2-1);  
        }
        // return longest(0,0,text1,text2,dp,text1.length()-1,text2.length()-1);
    }
}