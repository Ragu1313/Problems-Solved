/*
 Problem statement

Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.
For Example :

Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :

1 <= T <= 10
1 <= N,M <= 200

Note: It is guaranteed that the top-left cell does not have an obstacle.

Time Limit: 1 sec

Sample Input 1 :

2    
2 2
0 0
0 0
3 3
0 0 0 
0 -1 0 
0 0 0

Sample Output 1 :

2
2

Explanation For Sample Output 1 :

For the first test case, there are two possible paths to reach (2, 2) from (1, 1) : 
    (1, 1) -> (1, 2) -> (2, 2)
    (1, 1) -> (2, 1) -> (2, 2)

For the second test case, there are two ways to reach the bottom left corner - 
(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Sample Input 2 :

1
2 2
0 -1
-1  0

Sample Output 2 :

0
Solution:
*/
import java.util.*;
public class Solution {
    
    public static int maze(int i,int j,ArrayList<ArrayList<Integer>> mat,int dp[][]){
        if(i<0 || j<0)
            return 0;
        if(mat.get(i).get(j)==-1)
            return 0;
        if(i==0 && j==0)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = maze(i,j-1,mat,dp);
        int top = maze(i-1,j,mat,dp);
        return dp[i][j] = left+top;
    }
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int dp [][] = new int [n][m];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return maze(n-1,m-1,mat,dp);
    }

}
