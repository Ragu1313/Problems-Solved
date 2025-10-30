class Solution {
    public void helper(int row,int col,char [][] grid , int vis[][]){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        boolean change = true;
        int v1[] = {-1,0,1,0};
        int v2[] = {0,-1,0,1};
        int n = grid.length;
        int m = grid[0].length;
        List<int[]> li = new ArrayList<>();
        li.add(new int[]{row,col});
        while(!q.isEmpty()){
            int temp[] = q.poll();
            if(temp[0]==0 || temp[0]==n-1 || temp[1]==0 || temp[1]==m-1){
                change = false;
            }
            for(int k=0;k<4;k++){
                int newi = temp[0] + v1[k];
                int newj = temp[1] + v2[k];
                if(newi>=0 && newi<n && newj>=0 && newj<m && vis[newi][newj]==0 && grid[newi][newj]=='O'){
                    vis[newi][newj] = 1;
                    q.add(new int[]{newi,newj});
                    li.add(new int[]{newi,newj});
                }
            }
        }
        if(change){
            for(int i[] : li){
                grid[i[0]][i[1]] = 'X';
            }
        }
        
    }
    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O' && vis[i][j]==0){
                    helper(i,j,grid,vis);
                }
            }
        }
    }
}
