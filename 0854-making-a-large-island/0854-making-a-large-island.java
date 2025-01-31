class Solution {
    int v1[] = {-1,0,1,0};
    int v2[] = {0,-1,0,1};
    public int bfs(int i1,int j,int cnt,int grid[][],int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i1,j});
        grid[i1][j] = cnt;
        
        int c = 1;
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int ii = temp[0];
            int jj = temp[1];
            for(int i=0;i<4;i++){
                int e1 = ii+v1[i];
                int e2 = jj+v2[i];
                if(e1>=0 && e1<n && e2>=0 && e2<n && grid[e1][e2]==1){
                    c++;
                    q.add(new int[]{e1,e2});
                    grid[e1][e2] = cnt;
                }
            }
        }
        return c;

    }
    public int f(int i1,int j,int grid[][],Map<Integer,Integer> map,int n){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<4;i++){
            int ii = i1+v1[i];
            int jj = j+v2[i];
            if(ii>=0 && ii<n && jj>=0 && jj<n){
                set.add(grid[ii][jj]);
            }
        }
        int res = 1;
        for(int i : set){
            // if(i!=0)
            res+=map.get(i);
        }
        return res;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 3;
        map.put(0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int c = bfs(i,j,cnt,grid,n);
                    map.put(cnt,c);
                    cnt++;
                }
            }
        }
        if(cnt==3){
            return 1;
        }
        int res = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    res = Math.max(res,f(i,j,grid,map,n));
                }
            }
        }
        if(res==-1){
            return map.get(3);
        }
        return res;
    }
}