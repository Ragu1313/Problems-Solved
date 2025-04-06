class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int dp[] = new int[n];
        int ind[] = new int[n];
        int resind = 0;
        int len = -1;
        for(int i=0;i<n;i++){
            ind[i] = i;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    ind[i] = j;
                }
            }
            if(len<dp[i]+1){
                len = dp[i]+1;
                resind = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(arr[resind]);
        // resind = ind[resind];
        while(ind[resind]!=resind){
            resind = ind[resind];
            res.add(arr[resind]);
            
        }
        
        return res;
        
    }
}