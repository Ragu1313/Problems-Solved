class Solution {

    public int bs(int tar,int res[]){
        int left = 0;
        int right = res.length-1;
        int temp = -1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(res[mid]>=tar){
                temp = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return temp;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0])  return a[0] - b[0];
            return b[1] - a[1];
        });
        int n = envelopes.length;
        int res[] = new int[n];
        // for(int i[] : res){
        Arrays.fill(res,1000000);
        // }
        int maxi = 0;
        for(int i=0;i<n;i++){
            int ind = bs(envelopes[i][1],res);
            if(ind!=-1){
                res[ind] = envelopes[i][1];
                maxi = Math.max(maxi,ind+1);
            }
        }
        return maxi;
    }
}