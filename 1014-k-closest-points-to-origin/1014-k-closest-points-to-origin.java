class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            return a[0]*a[0]+a[1]*a[1] - b[0]*b[0] - b[1]*b[1];
        });
        int res[][] = new int[k][2];
        for(int i=0;i<points.length;i++){
            p.add(new int[]{points[i][0],points[i][1]});
        }
        int c= 0;
        while(k-->0){
            int arr[] = p.poll();
            res[c][0] = arr[0];
            res[c++][1] = arr[1];
        }
        return res;
    }
}