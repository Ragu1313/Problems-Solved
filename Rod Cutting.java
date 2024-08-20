/*
Rod Cutting
Difficulty: MediumAccuracy: 60.66%Submissions: 133K+Points: 4
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by 
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 
24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*price[1]= 8*3 = 24. 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
*/
class Solution{
    public int cut(int i,int price[],int n,int dp[][]){
        if(n==0)
            return 0;
        if(i==0)
            return n*price[0];
        if(dp[i][n]!=-1)
            return dp[i][n];
        int weight = i+1;
        int nottake = cut(i-1,price,n,dp);
        int take = Integer.MIN_VALUE;
        if(weight<=n)
            take = price[i]+cut(i,price,n-weight,dp);
        return dp[i][n] = Math.max(take,nottake);
    }
    public int cutRod(int price[], int n) {
        //code here
        int dp [][] = new int [n][n+1];
        for(int [] i: dp)
            Arrays.fill(i,-1);
        return cut(n-1,price,n,dp);
        
        
    }
}
