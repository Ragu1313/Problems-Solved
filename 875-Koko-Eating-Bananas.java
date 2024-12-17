class Solution {
    public int minEatingSpeed(int[] piles, int h1) {
        int l = 1;
        int h = -1;
        for(int i : piles){
            if(h<i)
            h = i;
        }
        int res = 0;
        int n = piles.length;
        long sum = 0;
        while(l<=h){
            // System.out.println(l+" "+h);
            int mid = l+(h-l)/2;
            for(int i=0;i<n;i++){
                int temp = piles[i]/mid;
                if(temp*mid < piles[i]){
                    temp = temp+1;
                }
                sum +=temp;
            }
            // System.out.println("sum "+sum);
            if(sum<=h1){
                res = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
            sum = 0;
        }
        return res;
    }
}