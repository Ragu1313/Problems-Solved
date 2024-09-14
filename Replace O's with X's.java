/*
Replace O's with X's
Difficulty: MediumAccuracy: 34.0%Submissions: 108K+Points: 4
Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Example 1:

Input: 
n = 5, m = 4
mat = {{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix. 
Example 2:

 

Input: 
n = 5, m = 4
mat = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix.
Your Task:
You do not need to read input or print anything. Your task is to complete the function fill() which takes N, M and mat as input parameters ad returns a 2D array representing the resultant matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
*/

class Solution{
    static int v1[] = new int[]{-1,0,1,0};
    static int v2[] = new int[]{0,-1,0,1};
    static void dfs(int index1,int index2,int n1,int m1, char grid[][], int visited[][]){
        visited[index1][index2] = 1;
            for(int i=0;i<4;i++){
                int n = v1[i]+index1;
                int m = v2[i]+index2;
                if(n>=0 && n<n1 && m>=0 && m<m1 && grid[n][m]=='O' && visited[n][m]==0)
                {
                    dfs(n,m,n1,m1,grid,visited);
                }
            }
        }
    
    
    static char[][] fill(int n, int m, char grid[][])
    {
        
        int [][] visited = new int[n][m];
        // Queue<int []> q = new LinkedList<>();
       
        for(int i=0;i<n;i++){
            if(grid[i][0]=='O')
                dfs(i,0,n,m,grid,visited);
            if(grid[i][m-1]=='O')
                dfs(i,m-1,n,m,grid,visited);
        }
        for(int i=1;i<m-1;i++){
            if(grid[0][i]=='O')
                dfs(0,i,n,m,grid,visited);
            if(grid[n-1][i]=='O')
                dfs(n-1,i,n,m,grid,visited);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0)
                    grid[i][j] = 'X';
            }
        }
        return grid;
    }
}
