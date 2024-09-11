class Solution {
    public int minBitFlips(int start, int goal) {
        int res =0;
        while(start!=goal){
            int t1 = start&1;
            int t2 = goal&1;
            if(t1!=t2) res++;
            start = start>>1;
            goal = goal>>1;
        }
        return res;
    }
}