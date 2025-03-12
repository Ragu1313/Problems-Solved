class Solution {
    public int f(int l,int h,int weights[],int k){
        int res = 1;
        int n = weights.length;
        while(l<=h){
            int mid = l+(h-l)/2;
            int curSum = 0;
            int tempk = 1;
            for(int i=0;i<n;i++){
                if(curSum+weights[i]<=mid){
                    curSum += weights[i];
                }
                else{
                    tempk++;
                    curSum  = weights[i];
                }
            }
            if(k<tempk){
                l = mid+1;
            }
            else {
                res = mid;
                h = mid-1;
            }
        }
        return res;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int low = 0;
        for(int i : weights){
            sum += i;
            low = Math.max(low,i);
        }
        return f(low,sum,weights,days);
    }
}