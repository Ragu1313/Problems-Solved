class Solution {
    public int startStation(int[] gas, int[] cost) {
        int prev = 0;
        int n = gas.length;
        int inx = 0;
        for(int i=0;i<n;i++){
            prev = prev + gas[i] - cost[i];
            if(prev<0){
                inx = i+1;
                prev = 0;
            }
        }
        prev = 0;
        for(int i=0;i<n;i++){
            int ind = (i+inx)%n;
            prev = prev + gas[ind] - cost[ind];
            if(prev<0){
                return -1;
            }
        }
        return inx;
    }
}