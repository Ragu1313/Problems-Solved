/*
Distance of nearest cell having 1
Difficulty: MediumAccuracy: 47.7%Submissions: 89K+Points: 4
Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.
 

Example 1:

Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0 
1 1 0 0 
0 0 1 1 
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
(2,1) are at a distance of 1 from 1's at (0,1),
(0,2), (0,2), (2,3), (1,0) and (1,1)
respectively.


Example 2:

Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
Output: {{0,1,0},{0,0,1},{0,1,2}}
Explanation: The grid is-
1 0 1
1 1 0
1 0 0
0's at (0,1), (1,2), (2,1) and (2,2) are at a 
distance of 1, 1, 1 and 2 from 1's at (0,0),
(0,2), (2,0) and (1,1) respectively.


 

Yout Task:
You don't need to read or print anything, Your task is to complete the function nearest() which takes the grid as an input parameter and returns a matrix of the same dimensions where the value at index (i, j) in the resultant matrix signifies the minimum distance of 1 in the matrix from grid[i][j].
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
*/
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public void near(int n1,int m1,int grid[][],int res[][],Queue<int[]>q){
        int v1[] = new int[]{0,-1,0,1};
        int v2[] = new int[]{-1,0,1,0};
        while(!q.isEmpty()){
            int []arr = q.poll();
            int i1 = arr[0];
            int j1 = arr[1];
            int value = arr[2];
            for(int i=0;i<4;i++){
                int n = i1+v1[i];
                int m = j1+v2[i];
                if(n>=0 && n<n1 && m>=0 && m<m1 && res[n][m]==-1){
                    q.add(new int[]{n,m,value+1});
                    res[n][m] = value+1;
                }
            }
        }
    }
    public int[][] nearest(int[][] grid)
    {
        int [][] res = new int[grid.length][grid[0].length];
        for(int i[]:res)
            Arrays.fill(i,-1);
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res[i][j] = 0;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        near(grid.length,grid[0].length,grid,res,q);
        return res;
    }
}

