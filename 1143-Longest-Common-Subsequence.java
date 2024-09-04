class Solution {
    // public int longest(int i,int j,String s1,String s2,int [][]dp,int l1,int l2){
    //     if(i>l1 || j>l2)
    //         return 0;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return 1+longest(i+1,j+1,s1,s2,dp,l1,l2);
    //     }
    //     else{
    //         return dp[i][j] = Math.max(longest(i,j+1,s1,s2,dp,l1,l2),longest(i+1,j,s1,s2,dp,l1,l2));
    //     }
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int [][] dp = new int [l1+1][l2+1];
        // for(int [] i:dp)
        //     Arrays.fill(i,-1);
        // for(int i=0;i<=l1;i++){
        //     dp[i][0] = 0;
        // }
        // for(int i=0;i<=l2;i++){
        //     dp[0][i] = 0;
        // }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];  

    }
}