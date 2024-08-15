class Solution {
    int maxi = 0;
    public int get(int row, int col, int[][] grid, int[][] visited) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) {
        return 0;
    }

    visited[row][col] = 1;

    int top = get(row - 1, col, grid, visited);
    int down = get(row + 1, col, grid, visited);
    int left = get(row, col - 1, grid, visited);
    int right = get(row, col + 1, grid, visited);

    visited[row][col] = 0;

    return grid[row][col] + Math.max(Math.max(top, down), Math.max(left, right));
}

    public int getMaximumGold(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                maxi = Math.max(maxi,get(i,j,grid,visited));
            }
        }
        return maxi;
    }
}