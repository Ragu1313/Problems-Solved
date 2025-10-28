class Solution {
    public int[][] f(Queue<int[] > q, int grid[][],int vis[][]){
        // if(grid[i][j]==1)  return 0;
        // Queue<int[]> q = new LinkedList<>();
        int res = 0;
        // q.add(new int[]{i,j});q
        int v1[] = {-1,0,1,0};
        int v2[] = {0,-1,0,1};
        // vis[i][j] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int temp[] = q.poll();
                int ii = temp[0];
                int jj = temp[1];
                
                for(int k=0;k<4;k++){
                    int newi = v1[k] + ii;
                    int newj = v2[k] + jj;
                    if(newi>=0 && newj>=0 && newi<grid.length && newj<grid[0].length && vis[newi][newj]==-1){
                        vis[newi][newj] = res+1;
                        q.add(new int[]{newi,newj});
                    }
                }
            }
            res++;
        }
        return vis;
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        ArrayList<ArrayList<Integer>> near = new ArrayList<>();
        int n = grid.length;
        for(int i=0;i<n;i++){
            near.add(new ArrayList<>());
        }
        int vis[][] = new int[n][grid[0].length];
        for(int i[] : vis){
            Arrays.fill(i,-1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                q.add(new int[]{i,j});
                vis[i][j] = 0;
                }
               
            }
        }
        int arr[][] =  f(q,grid,vis);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                near.get(i).add(arr[i][j]);
            }
        }
        return near;
    }
}