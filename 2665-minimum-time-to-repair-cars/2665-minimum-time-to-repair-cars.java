class Solution {
    public boolean f(int ranks[],int cars,long mid){
        long cnt = 0;
        for(int i=0;i<ranks.length;i++){
            long n  = mid/ranks[i];
            cnt = cnt + (long)(Math.sqrt(n));
        }   
        return cnt>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = Long.MAX_VALUE;
        long res = 0;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(f(ranks,cars,mid)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        } 
        return res;
    }
}