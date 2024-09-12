/*
Rotten Oranges
Difficulty: MediumAccuracy: 46.02%Submissions: 148K+Points: 4
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
*/
class Solution
{
    //Function to find minimum time required to rot all oranges.
    int res = 0;
    // int ans = 0;
    public void bfs(int n1,int m1,int grid[][],Queue<int[]> q){
        int v1[] = new int[]{-1,0,1,0};
        int v2[] = new int[]{0,-1,0,1};
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int index1 = arr[0];
            int index2 = arr[1];
            int ans = arr[2];
           
            for(int i=0;i<4;i++){
                int n = index1+v1[i];
                int m = index2+v2[i];
                if(n>=0 && n<n1 && m>=0 && m<m1 && grid[n][m]==1){
                    grid[n][m] = 2;
                    // visited[n][m] = 1;
                    // ans++;
                    // System.out.println(ans+1);
                    res = Math.max(res,ans+1);
                    q.add(new int[]{n,m,ans+1});
                }
            }
        }
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        // int [][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    // visited[i][j] = 1;
                }
            }
        }
        bfs(n,m,grid,q);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return res;
    }
}
