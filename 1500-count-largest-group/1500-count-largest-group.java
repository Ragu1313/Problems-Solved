class Solution {
    public int[] f(int n){
        int arr[] = new int[100000];
        for(int i=1;i<=n;i++){
            int temp = i;
            int sum = 0;
            while(temp>0){
                sum += temp%10;
                temp/=10;
            }
            arr[sum]++;
        }
        // for(int i : arr){
        //     System.out.print(i+" ");
        // }
        return arr;
    }
    public int countLargestGroup(int n) {
        int cnt [] = f(n);
        int maxi = 0;
        for(int i : cnt){
            maxi = Math.max(maxi,i);
        }
        int res = 0;
        for(int i : cnt){
            if(i==maxi) res++;
        }
        return  res;
    }
}