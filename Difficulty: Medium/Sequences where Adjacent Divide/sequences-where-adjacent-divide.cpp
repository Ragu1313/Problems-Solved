class Solution {
  public:
    int m;
    int n;
    int dp[20][20];
    int f(int i,int pre){
        if(i>=n){
            return 1;
        }
        int ans=0;
        if(dp[i][pre]!=-1)return dp[i][pre];
        set<int>st;
        for(int j=1;j<=pre;j++){
            if(pre%j==0){
                ans+=f(i+1,j);
                st.insert(j);
            }
        }
        for(int j=1;pre*j<=m;j++){
            if(st.count(pre*j)==0)
            ans+=f(i+1,pre*j);
        }
        return dp[i][pre]=ans;
    }
    int count(int num, int maxi) {
        // code here
        m=maxi;
        n=num;
        memset(dp,-1,sizeof dp);
        int ans=0;
        for(int i=1;i<=m;i++){
        ans+=f(1,i);
        }
        return ans;
    }
};
 