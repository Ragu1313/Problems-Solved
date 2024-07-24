class Solution {
    public int tribonacci(int n) {
    //    return   fib(n);
        int i;
        int arr[] = new int[n+3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        if(n<=2){
            return arr[n];
        }
        for(i=3;i<=n;i++){
           arr[i] = arr[i-1]+arr[i-2] +arr[i-3]; 
        } 
        return arr[n];
    }
}