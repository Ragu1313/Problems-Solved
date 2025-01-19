class Solution {
    public boolean c(int ii,int jj,int n,int m){
        if(ii>=0 && ii<n && jj>=0  && jj<m){
            return true;
        }
        return false;
    }
    public int trapRainWater(int[][] hei) {
        int res = 0;
        int n = hei.length;
        int m = hei[0].length;
        int vis[][] = new int[n][m];
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            p.add(new int[]{hei[i][0],i,0});
            p.add(new int[]{hei[i][m-1],i,m-1});
            vis[i][0] = 1;
            vis[i][m-1] = 1;
        }
        for(int i=0;i<m;i++){

            p.add(new int[]{hei[0][i],0,i});
            p.add(new int[]{hei[n-1][i],n-1,i});
            vis[0][i] = 1;
            vis[n-1][i] = 1;
        }
        int cur = 0;
        int v1[] = {-1,0,1,0};
        int v2[] = {0,-1,0,1};
        while(!p.isEmpty()){
            int arr[] = p.poll();
            int val = arr[0];
            if(cur<val){
                cur = val;
            }
            for(int i=0;i<4;i++){
                int ii = arr[1]+v1[i];
                int jj = arr[2]+v2[i];
                if(c(ii,jj,n,m) && vis[ii][jj]==0){
                    p.add(new int[]{hei[ii][jj],ii,jj});
                    vis[ii][jj] = 1;
                    if(hei[ii][jj]<cur){
                        res+=cur-hei[ii][jj];
                    }
                }
            }
        }
        return res;

    }
}