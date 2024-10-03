class Solution {
    public int minBitFlips(int start, int goal) {
        int rem = (start^goal);
        int res = 0;
        while(rem!=0){
            res = res+(rem&1);
            rem = rem>>1;
        }
        return res;
    }
}