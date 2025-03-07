class Solution {
    static long []arr = new long[1000001];
    static int flag = 0; 
    public void s(){
        arr[1] = 1; 
        for(long i = 2;i<1000000;i++){
            for(long j=i*i;j<1000000;j=j+i){
                arr[(int)j] = 1;
            }
        }
    }
    public int[] closestPrimes(int low, int high) {
        if(flag ==0 ){
            s();
            flag = 1;
        }
        int i = low;
        while(i<=high && arr[i]==1){
            i++;
        }
        int dif = Integer.MAX_VALUE;
        int res [] = {-1,-1}; 
        while(i<high){
            int j = i+1;
            while(j<=high && arr[j]==1){
                j++;
            }
            if(j<=high && dif>j-i){
                dif = j-i;
                res[0] = i;
                res[1] = j;
            }
            i = j;
        }
        return res;
    }
    
}