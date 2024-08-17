/*
 0 1 Knapsack
Easy
40/40
Average time to solve is 15m
Contributed by
314 upvotes
Asked in companies
Problem statement
A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10^2
1<= wi <= 50
1 <= vi <= 10^2
1 <= W <= 10^3

Time Limit: 1 second
Sample Input:
1 
4
1 2 4 5
5 4 8 6
5
Sample Output:
13
*/

public class Solution{
    static int knap(int []w,int [] v,int i,int mw,int dp[][]){
        if(i==0){
            if(w[0]<=mw)
                return v[0];
            else
                return 0;
        }
        if(dp[i][mw]!=-1)
            return dp[i][mw];
        int pick = Integer.MIN_VALUE;
        int notpick = 0+ knap(w,v,i-1,mw,dp);
        if(w[i]<=mw)
            pick = v[i] + knap(w,v,i-1,mw-w[i],dp);
        return dp[i][mw] = Math.max(pick,notpick);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) 
    {
        int dp[][] = new int [n][maxWeight+1];
        for(int [] i : dp)
            Arrays.fill(i,-1);
       return knap(weight,value,n-1,maxWeight,dp);

    }
}

