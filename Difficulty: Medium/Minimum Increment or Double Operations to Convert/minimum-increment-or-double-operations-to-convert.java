class Solution {
    // public int f(int i)
    public int countMinOperations(int arr[]) {
        int res = 0;
        int maxi = 0;
        for(int i : arr){
            int temp = 0;
            while(i>0){
                if(i%2==1){
                    i--;
                    res++;
                }
                else{
                    temp++;
                    i/=2;
                }
            }
            maxi = Math.max(temp,maxi);
        }
        return maxi+res;
    }
}