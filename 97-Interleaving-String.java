class Solution {
    public boolean fun(int i,int j,int l,String s1,String s2,String s3,int dp[][][]){
        if(l==s3.length()){
            // if(i==0 || j==0)
            //     return false;
            return true;
        }
        if(dp[i][j][l]!=-1) return dp[i][j][l]==1;
        int l1 = s1.length();
        int l2 = s2.length();
        boolean left = false;
        if(i<l1 && s1.charAt(i)==s3.charAt(l)){
            left = fun(i+1,j,l+1,s1,s2,s3,dp);
        }
        boolean right = false;
        if(j<l2 && s2.charAt(j)==s3.charAt(l)){
            right = fun(i,j+1,l+1,s1,s2,s3,dp);
        }
        dp[i][j][l] =  left||right?1:0;
        return left||right;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int [][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int [][] i:dp ){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return fun(0,0,0,s1,s2,s3,dp);
    }
}