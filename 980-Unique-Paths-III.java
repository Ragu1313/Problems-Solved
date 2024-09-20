class Solution {
    public int unique(int i,int j,int grid[][],int count,int n,int m,
    int visited[][]){
        if(!isValid(i,j,grid,n,m,visited)){
            return 0;
        }
        if(grid[i][j]==2){
            if(count==0){
                // System.out.println(count);
                return 1;
            }
                
            return 0;
        }
        int res = 0;
        visited[i][j] = 1;
        int left=unique(i,j+1,grid,count-1,n,m,visited);
        int right=unique(i,j-1,grid,count-1,n,m,visited);
        int top=unique(i-1,j,grid,count-1,n,m,visited);
        int bottom=unique(i+1,j,grid,count-1,n,m,visited);
        visited[i][j] = 0;
        return res = top+bottom+left+right;
    }
    public boolean isValid(int i,int j,int[][]grid,int n,int m,int[][]visited){
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j]!=-1 &&
         visited[i][j]==0){
            return true;
        }
        return false;
    }
    public int uniquePathsIII(int[][] grid) {
        int count=0,ini=0,inj=0;
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ini = i;
                    inj = j;
                }
                // count = count+grid[i][j]==0?1:0;
                if(grid[i][j]==0)   count++;
            }
        }
        // System.out.println(count);
        // visited[ini][inj] = 1;
        return unique(ini,inj,grid,count+1,n,m,visited);
    }
}