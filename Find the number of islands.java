/*
Find the number of islands
Difficulty: MediumAccuracy: 42.12%Submissions: 194K+Points: 4
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid = [[0,1],[1,0],[1,1],[1,0]]
Output: 1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
Output: 2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands :- one is colored in blue and other in orange.
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
0 ≤ grid[i][j] ≤ 1

*/

class Pair{
    public int first;
    public int second;
    public Pair(){
        super();
    }
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to find the number of islands.
    public void bfs(int row,int col,char grid[][],int [][] visited){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int f = q.peek().first;
            int s = q.peek().second;
            q.remove();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow = f + i;
                    int ncol = s + j;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                        if(visited[nrow][ncol]!=1 && grid[nrow][ncol]=='1'){
                    
                            q.add(new Pair(nrow,ncol));
                            visited[nrow][ncol] = 1;
                        }
                    }
                }
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]!=1 && grid[i][j]=='1'){
                    res++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return res;
    }
}
