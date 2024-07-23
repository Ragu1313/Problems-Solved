class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a = new HashMap<>();
        int i;
        int arr[] = new int[2];
        for(i=0;i<nums.length;i++){
            a.put(nums[i],i);
        }
        for(i=0;i<nums.length-1;i++){
            if(a.containsKey(target-nums[i]) && a.get(target-nums[i])!=i){
                arr[0] = i;
                arr[1] = a.get(target-nums[i]);
                return arr;
            }
        }
        return arr;
    }
}