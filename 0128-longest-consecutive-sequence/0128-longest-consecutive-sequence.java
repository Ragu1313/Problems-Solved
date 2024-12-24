class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums)   set.add(i);
       
        int res = 0;
        for(int i:nums){
            int left = i-1;
            int right = i+1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            res = Math.max(res,right-left-1);
        }
        return res;
    }
}