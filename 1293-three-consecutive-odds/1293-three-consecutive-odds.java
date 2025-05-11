class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for(int i : arr){
            if((i&1)==1){
                cnt++;
                if(cnt==3)  return true;
            }
            else    cnt = 0;
        }
        return false;
    }
}