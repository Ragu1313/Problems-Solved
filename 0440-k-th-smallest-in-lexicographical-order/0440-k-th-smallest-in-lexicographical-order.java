class Solution {

    public int count(long n,long num,long num1){
        int steps = 0;
        while(num<n){
            steps += Math.min(num1,n)-num;
            num1*=10;
            num*=10;
        }
        return steps;
    }

    public int findKthNumber(int n, int k) {
        long n1 = (long)(n+1);
        // int res = 1;
        k--;
        long num = 1;
        while(k>0){
            int dif = count(n1,num,num+1);
            if(dif<=k){
                k-=dif;
                num++;
            }
            else{
                num*=10;
                k--;
            }
        }
        return (int)num;
    }
}