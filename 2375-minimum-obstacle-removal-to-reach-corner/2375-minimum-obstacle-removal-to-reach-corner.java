class Solution {

    public boolean check(int i,int j,int n,int m,int grid[][]){
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j]!=2){
            return true;
        }
        return false;
    }

    public int f(int [][] grid){
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        p.add(new int[]{0,0,0});
        grid[0][0] = 2;
        int v1 []= new int[]{-1,0,1,0};
        int v2 [] = new int[]{0,-1,0,1};
        int n = grid.length;
        int m = grid[0].length;
        while(!p.isEmpty())
        {
            int arr[] = p.poll();
            int val = arr[0];
            if(arr[1]==n-1 && arr[2]==m-1){
                return val;
            }
            for(int i=0;i<4;i++){
                int ii = v1[i]+arr[1];
                int jj = v2[i]+arr[2];
                if(check(ii,jj,n,m,grid)){
                    if(grid[ii][jj]==1){
                        p.add(new int[]{val+1,ii,jj});
                        grid[ii][jj] = 2;
                    }
                    else{
                        p.add(new int[]{val,ii,jj});
                        grid[ii][jj] = 2;
                    }
                }
            }
        }
        return -1;
    }


    public int minimumObstacles(int[][] grid) {
        return f(grid);
    }
}
