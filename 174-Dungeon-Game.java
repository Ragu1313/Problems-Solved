class Solution {
    // int res = 0;
    // public int f(int i,int j,int mat[][],int dp[][]){
        
    // }
    public int calculateMinimumHP(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[0]-a[0]);
        q.add(new int[]{mat[0][0],0,0});
        int v1[] = {1,0};
        int v2[] = {0,1};
        // in
        // mat[0][0] = 2000;
        int vis[][] = new int[n][m];
        for(int i[]:vis){
            Arrays.fill(i,Integer.MIN_VALUE);
        }
        int val1 = 0;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int val = arr[0];
            int ii = arr[1];
            int jj = arr[2];
            val1 = Math.min(val,val1);
            if(ii==n-1 && jj==m-1){
                System.out.println(val1);
                return 1 + Math.abs(val1);
            }
            for(int i=0;i<2;i++){
                int n1 = ii+v1[i];
                int m1 = jj+v2[i];
                if(n1>=0 && n1<n && m1>=0 && m1<m && vis[n1][m1]<val+mat[n1][m1]){
                    q.add(new int[]{val+mat[n1][m1],n1,m1});
                    vis[n1][m1] = val + mat[n1][m1];
                    // mat[n1][m1] = 2000;
                }
            }
        }
        return -1;
    }
}