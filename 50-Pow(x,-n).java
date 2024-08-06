class Solution {
    public double myPow(double x, int N) {
        long n = N;
        if(n<0){
            n = -n;
            x=1/x;
        }
        double res = 1;
        while(n>0){
            if(n%2==0){
                x=x*x;
                n = n/2;
            }
            else{
                res = res*x;
                n=n-1;
            }    
        }
        return res;
    }
}