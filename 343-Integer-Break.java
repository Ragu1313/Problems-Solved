class Solution {
    
    public int integerBreak(int n) {
        int res = 1;
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }
        while(n>4){
            res = res*3;
            n-=3;
        }
        res=res*n;
        return res;
    }
}