class Solution {
    public int reverse(int i){
        int rev = 0;
        while(i>0){
            rev = rev*10 + i%10;
            i/=10;
        }
        return rev;
    }

    public int countNicePairs(int[] nums) {
        long res = 0;
        int mod = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int key = i - reverse(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int val : map.values()) {
            long count = val;
            res = (res + (count * (count - 1) / 2) % mod) % mod;
        }

        return (int) res;
    }
}
