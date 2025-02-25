class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i : nums){
            sum += i;
            int rem = sum%k;
            if(rem<0){
                rem = rem+k;
            }
            if(map.get(rem)!=null) {
                res += map.get(rem);
                // System.out.println(sum+" "+res);
                map.put(rem,map.get(rem)+1);
            }
            else{
                map.put(rem,1);
            }
            // System.out.println(map);
        }
        return res;
    }
}