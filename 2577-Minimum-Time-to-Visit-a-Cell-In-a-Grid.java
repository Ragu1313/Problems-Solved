class Solution {

    public int f(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        if(mat[0][0]==0)
        p.add(new int[]{0,0,0});
        int v1[] = {-1,0,1,0};
        int v2[] = {0,-1,0,1};
        int vis[][] = new int[n][m];
        vis[0][0] = 1;
        while(!p.isEmpty()){
            int arr[] = p.poll();
            int row = arr[1];
            int col = arr[2];
            int cnt = arr[0];
            // if(row==n-1 && col==m-1){
            //     return cnt;
            // }
            cnt++;
            for(int i=0;i<4;i++){
                int ii = row+v1[i];
                int jj = col+v2[i];
                if(ii<0 || ii>=n || jj<0 || jj>=m || vis[ii][jj]==1 ){
                    continue;
                }
                int newtime = cnt;
                if( mat[ii][jj]>newtime){
                    int diff = mat[ii][jj] - newtime;
                    if(diff%2==0){
                        newtime = newtime + diff;
                    }
                    else{
                        newtime = newtime + diff+1;
                    }
                }
                if(ii==n-1 && jj==m-1)
                    return newtime;
                
                p.add(new int[]{newtime,ii,jj});
                vis[ii][jj] = 1;
            }
        }
        return -1;
    }

    public int minimumTime(int[][] grid) {
        if(grid[0][0]>0 || (grid[0][1]>1  && grid[1][0]>1)){
            return -1;
        }
        return f(grid);
    }
}