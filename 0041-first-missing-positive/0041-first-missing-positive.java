class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
        int  j = 0;
        while(j<n && nums[j]<=0)    j++;
        int num = 1;
        while(j<n){
            int i = nums[j];
            if(num!=i){
                return num;
            }
            num++;
            while(j<n && nums[j]==i)    j++;
            // j++;
        }

        return num;
    }
}