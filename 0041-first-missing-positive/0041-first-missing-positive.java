class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        int num = 1;
        for(int i : set){
            if(num!=i){
                return num;
            }
            num++;
        }

        return num;
    }
}