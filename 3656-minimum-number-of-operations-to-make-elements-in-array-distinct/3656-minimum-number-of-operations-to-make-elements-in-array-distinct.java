class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for(int j=nums.length-1;j>=0;j--){
            int i = nums[j];
            if(!s.add(i)) {
                res = j+1;
                break;
            }
        }
        return (int)Math.ceil(res/3.0);
        
        
    }
}