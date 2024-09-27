class Solution {
    public void bfs(int n1,int m1,Queue<int[]> q,int [][] res){
        int []v1 = new int[]{-1,0,1,0};
        int []v2 = new int[]{0,-1,0,1};
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int i1 = arr[0];
            int j1 = arr[1];
            int cnt = arr[2];
            for(int i=0;i<4;i++){
                int n = v1[i]+i1;
                int m = v2[i]+j1;
                if(n<n1 && n>=0 && m<m1 && m>=0 && res[n][m]==-1){
                    res[n][m] = cnt+1;
                    q.add(new int[]{n,m,cnt+1});
                }
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int n1 = mat.length;
        int m1 = mat[0].length;
        // int h
        int res[][] = new int[n1][m1];
        for(int i[]:res)
            Arrays.fill(i,-1);
        for(int i=0;i<n1;i++){
            for(int j=0;j<m1;j++){
                if(mat[i][j]==0){
                    res[i][j] = 0;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        bfs(n1,m1,q,res);
        return res;
    }
}