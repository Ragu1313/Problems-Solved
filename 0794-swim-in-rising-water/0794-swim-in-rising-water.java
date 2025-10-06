class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        int res = grid[0][0];
        int n = grid.length;
        int dir[][] = {  
            {-1,0} , {0,-1} , {1,0} , {0,1}
        };
        int vis[][] = new int[n][n];
        while(!pq.isEmpty()){
            int temp[] = pq.poll();
            int i = temp[1];
            int j = temp[2]; 
            res = Math.max(res,temp[0]);
            if(i==n-1 && j==n-1) {
                return res;
            }
            for(int k=0;k<4;k++){
                int newi = i + dir[k][0];
                int newj = j + dir[k][1];
                if(newi>=0 && newj>=0 && newi<n && newj<n &&vis[newi][newj]==0){
                    vis[newi][newj] = 1;
                    pq.add(new int[]{grid[newi][newj],newi,newj});
                }
            }
        }
        return -1;
    }
}