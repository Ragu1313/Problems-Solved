class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int res = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                break;
            }
            cnt++;
        }
        res = cnt;
        cnt = 0;
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
                break;
            }
            cnt++;
        }
        res = Math.max(cnt,res);
        int ans = 0;
        cnt= 0;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                ans = Math.max(cnt,ans);
                cnt= 0;
            }
            else    cnt++;
        }
        res = Math.max(res,(ans+1)/2);
        return res;
    }
}