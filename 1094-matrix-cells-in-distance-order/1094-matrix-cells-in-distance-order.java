class Solution {
    boolean check(int i,int j,int r,int c,int a[][]){
        if(i<0 || j<0 || i>=r|| j>=c || a[i][j]==1){
            return false;
        }
        return true;
    }
    public int[][] allCellsDistOrder(int rows, int cols, int r, int co) {
        int ans[][]=new int[rows*cols][2];
        int c = 0;
        int a[][] = new int[rows][cols];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{r,co});
        a[r][co] = 1;
        int v1[] = {-1,0,1,0};
        int v2[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int arr[] = q.poll();
            // System.out.println(arr[0]+" "+arr[1]);
            ans[c][0] = arr[0];
            ans[c++][1] = arr[1];
            for(int i=0;i<4;i++){
                int n1 = v1[i]+arr[0];
                int m1 = v2[i]+arr[1];
                if(check(n1,m1,rows,cols,a)){
                    q.add(new int[]{n1,m1});
                    a[n1][m1] = 1;
                }
            }
        }
        return ans;
    }
}