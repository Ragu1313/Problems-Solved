class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int rowmin = row;
        int rowmax = 0;
        int colmin = col;
        int colmax = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    rowmin = Math.min(i,rowmin);
                    rowmax = Math.max(i,rowmax);
                    colmin = Math.min(colmin,j);
                    colmax = Math.max(colmax,j);
                }
            }
        }
        int l = rowmax - rowmin+1;
        int b = colmax - colmin +1;
        return l*b;
    }
}