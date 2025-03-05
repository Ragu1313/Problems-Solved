class Solution {
    public long coloredCells(int n) {
        long res = 0;
        int cnt = 4;
        if(n-->0)
        res = res + 1;
        while(n-->0){
            res += cnt;
            cnt+=4;
        }
        return res;
    }
}