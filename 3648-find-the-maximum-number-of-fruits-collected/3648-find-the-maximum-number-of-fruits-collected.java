class Solution {
    public int f1(int i,int j,int n,int startcol,int dp[][],int mat[][]){

        if(i==n-1) {
            if(j==n-1){
                return mat[i][j];
            }  
            return - (int)(1e6);
        }

        if(dp[i][j]!=-1)  return dp[i][j];

        int res = Integer.MIN_VALUE;
         
        if(i+1<n && j-1>=startcol){
            res = Math.max(f1(i+1,j-1,n,startcol,dp,mat),res);
        }
        if(i+1<n ){
            res = Math.max(f1(i+1,j,n,startcol,dp,mat),res);
        }
        if(j+1<n){
            res = Math.max(f1(i+1,j+1,n,startcol,dp,mat),res);
        }

        return dp[i][j] = res + mat[i][j];
    }

    public int f2(int i,int j,int startrow,int n,int mat[][], int dp[][]){
        if(j==n-1){
            if(i==n-1){
                return mat[i][j];
            }
            return -(int)(1e6);
        }

        if(dp[i][j]!=-1)  return dp[i][j];

        int res = Integer.MIN_VALUE;
        if(i-1>=startrow && j+1<n){
            res = Math.max(res,f2(i-1,j+1,startrow,n,mat,dp));
        }
        if(j+1<n){
            res = Math.max(res,f2(i,j+1,startrow,n,mat,dp));
        }
        if(i+1<n && j+1<n){
            res = Math.max(res,f2(i+1,j+1,startrow,n,mat,dp));
        }

        return dp[i][j] = res + mat[i][j];
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int dp[][] = new int[n][n];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        int i=0;
        int j=0;
        int res = 0;
        while(i<n){
            res += fruits[i][j];
            fruits[i][j] = 0;
            i++;j++;
        }
        // res  = res;
        int temp1 = f2(n-1,0,n/2,n,fruits,dp); 
        for(int ii[] : dp){
            Arrays.fill(ii,-1);
        }
        int temp2 = f1(0,n-1,n,n/2,dp,fruits);
        // System.out.println(temp1 + " "+res);
        // System.out.println(temp2);
        
        return res +temp2+temp1;
    }
}