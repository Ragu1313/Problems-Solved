class Solution {
    static int flag = 0;
    static long arr[] = new long[1001];
    
    public void f(){
        int mod = (int)(1e9+7);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        int left = 1;
        for(int i=4;i<=1000;i++){
            arr[i] = ((arr[i-1]*2)%mod+arr[left])%mod;
            left++;
        }
    }
    public int numTilings(int n) {
        if(flag==0){
            flag =1;
            f();
        }
        return (int)arr[n];
    }
}