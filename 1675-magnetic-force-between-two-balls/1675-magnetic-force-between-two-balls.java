class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n = pos.length;
        int l = 0;
        int h = pos[n-1];
        int res = 0;
        while(l<=h){
            int mid = l+(h-l)/2;
            int k = m-1;
            // System.out.println(k);
            int prev = pos[0];
            for(int i=1;i<n;i++){
                if(pos[i]-prev>=mid){
                    k--;
                    prev = pos[i];
                }
            }
            if(k<=0){
                res = mid;
                l = mid+1;
                // h = n-1;
            }
            else{
                h = mid-1;
            }
        }
        return res;
    }
}