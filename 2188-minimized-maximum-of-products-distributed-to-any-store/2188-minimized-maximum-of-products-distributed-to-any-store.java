class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int l = 1;
        int h = 0;
        for(int i:q){
            h = Math.max(i,h);
        }
        int res = 0;
        while(l<=h){
            int mid = l + ((h - l) >> 1);
            int k = n;
            for(int i : q){
                int temp = i/mid;
                if(i%mid!=0){
                    temp++;
                }
                k = k-temp;
            }
            if(k>=0){
                res = mid;
            }
            if(k>=0){
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return res;
    }
}