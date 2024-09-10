/*
Flood fill Algorithm
Difficulty: MediumAccuracy: 41.11%Submissions: 119K+Points: 4
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the new color.

Examples:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2.
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected by a path of the same color as the starting pixel are colored with the new color.Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 <= n <= m <= 500
0 <= pixel values <= 10
0 <= sr <= (n-1)
0 <= sc <= (m-1)
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

class Solution
{
    
    public void bfs(int row,int col,int grid[][],int [][] visited,int color){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
	int temp = grid[row][col];
        if(grid[row][col]!=color)
        grid[row][col] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        
        while(!q.isEmpty()){
            int f = q.peek().first;
            int s = q.peek().second;
            q.remove();
            
            int nrow =f-1;
            int ncol =s;
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if(visited[nrow][ncol]!=1 && grid[nrow][ncol]==temp){
                    q.add(new Pair(nrow,ncol));
                    grid[nrow][ncol] = color;
                    visited[nrow][ncol] = 1;
                }
            }
            nrow =f;
            ncol =s -1;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if(visited[nrow][ncol]!=1 && grid[nrow][ncol]==temp){
                    q.add(new Pair(nrow,ncol));
                    grid[nrow][ncol] = color;
                    visited[nrow][ncol] = 1;
                }
            }
            nrow =f+ 1;
            ncol =s;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if(visited[nrow][ncol]!=1 && grid[nrow][ncol]==temp){
                    q.add(new Pair(nrow,ncol));
                    grid[nrow][ncol] = color;
                    visited[nrow][ncol] = 1;
                }
            }
            nrow =f;
            ncol =s+1;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if(visited[nrow][ncol]!=1 && grid[nrow][ncol]==temp){
                    q.add(new Pair(nrow,ncol));
                    grid[nrow][ncol] = color;
                    visited[nrow][ncol] = 1;
                }
            }
            
        }
        
    }
    
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor)
    {
        // Code here 
        int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int[n][m];
        int temp = grid[sr][sc];
        // if(temp!=newColor)
        bfs(sr,sc,grid,visited,newColor);
        return grid;
    }
}
