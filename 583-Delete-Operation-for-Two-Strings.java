class Solution {
    public int min(int i,int j,String word1,String word2,int dp[][]){
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;
        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);
        if(dp[i][j]!=-1)    return dp[i][j];
        if(ch1==ch2) return dp[i][j] = min(i-1,j-1,word1,word2,dp);
        else{
            int l = 1+min(i-1,j,word1,word2,dp);
            int r = 1+min(i,j-1,word1,word2,dp);
            return dp[i][j] = Math.min(l,r);
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return min(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
}