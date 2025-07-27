class Solution {

    public boolean isPalindrome(int i,int j,String s){
        while(i<=j &&  s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return i>j;
    }

    public int f(int prev,int inx,String s,int dp[][]){
        int len = s.length();
        if(inx==len-1){
            if(isPalindrome(prev,inx,s))  return 0;
            return len - prev;
        }
        if(dp[prev][inx]!=-1)  return dp[prev][inx];

        int res = f(prev,inx+1,s,dp);

        if(isPalindrome(prev,inx,s)){
            res = Math.min(f(inx+1,inx+1,s,dp)+1,res);
        }

        return dp[prev][inx] = res;
    }

    public int minCut(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return f(0,0,s,dp);
    }
}