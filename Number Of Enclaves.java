/*
Number Of Enclaves
Difficulty: MediumAccuracy: 50.93%Submissions: 74K+Points: 4
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:

Input:
grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
Output:
3
Explanation:
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
The highlighted cells represents the land cells.
Example 2:

Input:
grid[][] = {{0, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0}}
Output:
4
Explanation:
0 0 0 1
0 1 1 0
0 1 1 0
0 0 0 1
0 1 1 0
The highlighted cells represents the land cells.
Your Task:

You don't need to print or input anything. Complete the function numberOfEnclaves() which takes a 2D integer matrix grid as the input parameter and returns an integer, denoting the number of land cells.

Expected Time Complexity: O(n * m)

Expected Space Complexity: O(n * m)

Constraints:

1 <= n, m <= 500
grid[i][j] == 0 or 1
*/


class Solution {
    
    void bfs(int n1,int m1,Queue<int[]> q,int[][] grid,int [][] visited){
        int v1[] = new int[]{-1,0,1,0};
        int v2[] = new int[]{0,-1,0,1};
        
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int i1 = arr[0];
            int j1 = arr[1];
            for(int k=0;k<4;k++){
                int n = i1+v1[k];
                int m = j1+v2[k];
                if(n<n1 && n>=0 && m>=0 && m<m1 && grid[n][m]==1 && visited[n][m]==0){
                    visited[n][m] = 1;
                    q.add(new int[]{n,m});
                }
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int [n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                q.add(new int[]{i,0});
                visited[i][0] = 1;
            }
            if(grid[i][m-1]==1){
                q.add(new int[]{i,m-1});
                visited[i][m-1] = 1;
            }
        }
        for(int i=1;i<m-1;i++){
            if(grid[0][i]==1){
                q.add(new int[]{0,i});
                visited[0][i] = 1;
            }
            if(grid[n-1][i]==1){
                q.add(new int[]{n-1,i});
                visited[n-1][i] = 1;
            }
        }
        bfs(n,m,q,grid,visited);
        int res = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==1 && visited[i][j]==0)
                    res++;
            }
        }
        return res;
    }
    
}
