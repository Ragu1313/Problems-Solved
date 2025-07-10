class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int v1[] = {-1,0,-1,1,1,1,0,-1};
        int v2[] = {0,-1,-1,-1,0,1,1,1};
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]==0){
            q.add(new int[]{0,0});
        }
        // else{
        //     return -1;
        // }
        int n = grid.length;
        int m = grid[0].length;

        // if(n-1==0 && m-1==0)  return 0;
        int cnt = 1;
        int vis[][] = new int[n][m];
        for(int i[] : vis){
            Arrays.fill(i,Integer.MAX_VALUE);
        } 
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int temp[] = q.poll();
                // System.out.println(cnt);
                if(temp[0]==n-1 && temp[1]==m-1)   return cnt;
                for(int i=0;i<8;i++){
                    int row = temp[0] + v1[i];
                    int col = temp[1] + v2[i];
                    if(row>=0 && row<n && col>=0 && col<m && vis[row][col]>cnt && grid[row][col]==0){
                        vis[row][col] = cnt;
                        q.add(new int[]{row,col});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}