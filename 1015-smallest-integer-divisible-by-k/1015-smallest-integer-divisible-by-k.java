class Solution {
    public int smallestRepunitDivByK(int k) {
        int res = 1;
        int rem = 0;
        Set<Integer> set = new HashSet<>();
        while(res<10000000){
            if(!set.add(rem)){
                return -1;
            }
            rem = rem*10 + 1;
            if(rem%k==0){
                return res ;
            }
            rem = rem % k;
            res++;
        }
        return -1;
    }
}