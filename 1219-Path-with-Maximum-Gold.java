class Solution {
    int maxi = 0;
    public int get(int row,int col,int grid[][],int visited[][]){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col]==1 || grid[row][col]==0)
            return 0;
        int left,right,top,down;
        
        visited[row][col] = 1;
        top = get(row-1,col,grid,visited);
        down = get(row+1,col,grid,visited);
        left = get(row,col-1,grid,visited);
        right = get(row,col+1,grid,visited);
        visited[row][col] = 0;
            
        return grid[row][col]+Math.max(Math.max(left,right),Math.max(top,down)); 
    }
    public int getMaximumGold(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                maxi = Math.max(maxi,get(i,j,grid,visited));
            }
        }
        return maxi;
    }
}