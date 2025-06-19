class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        int res = 0;
        int n = points.length;
        int prev = points[0][1];
        for(int i=1;i<n;i++){
            if(prev<points[i][0]){
                res++;
                prev = points[i][1];
            }
            else{
                prev = Math.min(prev,points[i][1]);
            }
        }
        return res+1;
    }
}