class Solution {
    public boolean f(int ind1,int ind2,int n1,int n2,String s,String p,Boolean dp[][]){
        if(ind1==n1 ){
            while(ind2+1<n2){
                if(p.charAt(ind2)!='*' && p.charAt(ind2+1)=='*'){
                    ind2+=2;
                }
                else{
                    return false;
                }
            }
            return ind2==n2;
        }
        if(dp[ind1][ind2]!=null)  return dp[ind1][ind2] ;
        if(ind1==n1 || ind2==n2) {
            return  false;
        }
        char ch1 = s.charAt(ind1);
        char ch2 = p.charAt(ind2);
        if(ch2=='.'){
            ch2 = ch1;
        }
        if(ind2+1<n2 && p.charAt(ind2+1)=='*' ){

            if(f(ind1,ind2+2,n1,n2,s,p,dp)){
                return dp[ind1][ind2] = true;
                //  true;
            }
            if(ch1==ch2){
                if(f(ind1+1,ind2,n1,n2,s,p,dp)){
                    return dp[ind1][ind2] = true;
                    //  true;
                }
                if(f(ind1+1,ind2+2,n1,n2,s,p,dp)) {
                    return dp[ind1][ind2] = true;
                    // return ;
                }
            }
        }
        else if(ch1==ch2 && f(ind1+1,ind2+1,n1,n2,s,p,dp)){
            return dp[ind1][ind2] = true;
            // return true;
        }
        // 0;
        return  dp[ind1][ind2] = false;
        
    }
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        Boolean dp[][] = new Boolean[n1][n2+1];
        // for(int i[] : dp){
        //     Arrays.fill(i,-1);
        // }
        return f(0,0,s.length(),p.length(),s,p,dp);
    }   
}