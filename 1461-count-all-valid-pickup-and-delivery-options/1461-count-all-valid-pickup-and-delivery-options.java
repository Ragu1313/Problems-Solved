class Solution {
    int mod = (int)(1e9+7);
    public int countOrders(int n) {
        n = n*2;
        long res = 1;
        while(n>0){
            res = (res*(n*(n-1)/2))%mod;
            n = n-2;
        }
        return (int)(res%mod);
    }
}