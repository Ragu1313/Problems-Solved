class Solution {
    public int countPrimes(int n) {
        if(n==0) return 0;
        int []arr = new int[n];
        // arr[1] = -1;
        // arr[0] = 0;
        int l = (int)Math.sqrt(n); 
        for(int i=2;i<=l;i++){
            for(int j=i*i;j<n;j=j+i){
                arr[j] = -1;   
            }
        }
        l = n;
        int count = 0;
        for(int i=2;i<l;i++){
            if(arr[i]==0)
                count++;
        }    
        return count;
    }
}