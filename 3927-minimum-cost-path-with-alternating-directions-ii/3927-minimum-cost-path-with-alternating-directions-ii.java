class Solution {
    public long minCost(int n, int m, int[][] mat) {
       PriorityQueue<long[]> p = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        // int n = mat.length;
        // int m = mat[0].length;
        p.add(new long[]{1,0,0,1});
        int dir[][] =  {{1,0},{0,1}};
        int vis[][] = new int [n][m];
        vis[0][0] =  1;
        while(!p.isEmpty()){
            long temp [] = p.poll();
            // System.out.println(Arrays.toString(temp));
            int i = (int)temp[1];
            int j = (int)temp[2];
            int flag = (int)temp[3];
            if(i==n-1 && j==m-1)  return temp[0];
            if(flag==0){
                // temp[0] += mat[i][j];
                flag = 1;
                // System.out.println(temp[0]+ mat[i][j] + " "+i+" "+j+" "+1);
                p.add(new long[]{temp[0] + mat[i][j],(long)i,(long)j,(long)flag});
            }
            else{
                for(int row = 0;row<2;row++){
                    int newi = dir[row][0] + i;
                    int newj = dir[row][1] + j;
                    if(newi>=0 && newi<n && newj>=0 && newj<m && vis[newi][newj]==0){
                        vis[newi][newj] = 1;
                        // System.out.println(temp[0]+ mat[i][j] + " "+i+" "+j+" "+1);
                        p.add( new long[] {temp[0] + (newi+1) * (newj+1),(long)newi,(long)newj,(long)0});
                    }
                }
            }
        }
        return -1;
    }
}