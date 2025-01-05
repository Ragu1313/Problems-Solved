class Solution {
    // boolean check(int i,int j,int r,int c,int a[][]){
    //     if(i<0 || j<0 || i>=r|| j>=c || a[i][j]==1){
    //         return false;
    //     }
    //     return true;
    // }
    public int[][] allCellsDistOrder(int rows, int cols, int r, int co) {
        int ans[][]=new int[rows*cols][2];
        int c = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            int x = Math.abs(a[0]-r) + Math.abs(a[1]-co);
            int y = Math.abs(b[0]-r) + Math.abs(b[1]-co);
            return Integer.compare(x,y);
    });
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                p.add(new int[]{i,j});
            }
        }
        while(!p.isEmpty()){
            int arr[ ] = p.poll();
            ans[c][0] = arr[0];
            ans[c++][1] = arr[1];
        }
        return ans;
    }
}