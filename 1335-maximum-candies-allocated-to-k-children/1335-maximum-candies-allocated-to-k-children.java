class Solution {
    public boolean f(int [] candies , long k,int mid,int n){
        long cnt = 0;
        for(int i=0;i<n;i++){
            cnt += candies[i]/mid;
            if(cnt>=k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int n =  candies.length;
        int l = 1;
        int r = candies[n-1];
        int res = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(f(candies,k,mid,n)){
                res = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }

        }
        return res;
    }
}