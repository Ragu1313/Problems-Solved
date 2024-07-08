/*
120. Triangle
Solved
Medium
Topics
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

  Solution:
*/
class Solution {
    public int min(int i,int j,int n,List<List<Integer>> triangle,int dp[][]){
        if(i>n || j>=triangle.get(i).size())
            return (int)Math.pow(10,9);
        if(i==n)
            return triangle.get(i).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int bottom = triangle.get(i).get(j) + min(i+1,j,n,triangle,dp);
        int adj = triangle.get(i).get(j) + min(i+1,j+1,n,triangle,dp);
        return dp[i][j] = Math.min(bottom,adj);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int [][] dp = new int[n][m];
        for(int[]i:dp)
            Arrays.fill(i,-1);
        return min(0,0,n-1,triangle,dp);
    }
}
