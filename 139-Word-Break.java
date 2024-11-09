class Solution {
    public boolean check(int ii,String s,String s2){
        if(s.substring(ii,s.length()).length()<s2.length()){
            return false;
        }
        for(int i=0;i<s2.length();i++){
            if(s.charAt(ii)==s2.charAt(i)){
                ii++;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean f(int i,String s,List<String> word,int dp[]){

        if(i>=s.length()){
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==1;
        }
        for(int j=0;j<word.size();j++){
            if(s.charAt(i)==word.get(j).charAt(0)){
                if(check(i,s,word.get(j))){
                    if(f(i+word.get(j).length(),s,word,dp)){
                        dp[i] = 1;
                        return true;
                    }
                }
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return  f(0,s,wordDict,dp);
    }
}