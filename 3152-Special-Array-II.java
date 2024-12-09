class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // int arr[] = new int[nums.length];
        boolean res[] = new boolean[queries.length];
        int sum[] = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            int e1 = nums[i-1]&1;
            int e2 = nums[i]&1;
            if(e1==e2){
                sum[i] = sum[i-1]+1;
            }
            else{
                sum[i] = sum[i-1];
            }
        }
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(sum[start]==sum[end]){
                res[i] = true;
            }
            else{
                res[i] = false;
            }
        }
        return res;
    }
}