class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            // if(points[i][0]==-100000)  continue;
            Map<Double,Integer> map = new HashMap<>();
            for(int j=i+1;j<n;j++){
                // if(points[j][0]==-100000)  continue;
                double temp ;
                if(points[j][0] - points[i][0]==0){
                    temp = -100000;
                }
                else
                    temp = (points[j][1] - points[i][1])/((points[j][0] - points[i][0])*1.0);
                // System.out.println(temp);
                if(temp==0){
                    temp = 0;
                }
                map.put(temp,map.getOrDefault(temp,0)+1);
                // if(map.get(temp)>1){
                //     points[j][0] = -100000; 
                // }
            }
            for(double m : map.keySet()){
                // if(map.get(m)>=1){
                cnt=Math.max(cnt,map.get(m));
                // }
            }
        }
        return cnt+1;
    }
}