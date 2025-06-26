class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = bloomDay[0];
        int right = bloomDay[0];
        for(int i:bloomDay){
            left = Math.min(i,left);
            right = Math.max(i,right);
        }
        // int right = min;
        int res = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            // int i=0;
            int temp = 0;
            int cnt = 0;
            for(int i=0;i<bloomDay.length;i++){
                if(mid>=bloomDay[i]){
                    temp++;
                    if(temp==k) {
                        cnt++;
                        temp = 0;
                    }
                }
                else  temp = 0;
            }
            if(cnt>=m){
                res = Math.min(res,mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
        
    }
} 