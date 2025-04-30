class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int i:nums){
            int cnt =(int)Math.floor( Math.log10(i) );
            if((cnt&1)==1){
                res++;
            }
            // System.out.println(cnt);
        }
        return res;
    }
}