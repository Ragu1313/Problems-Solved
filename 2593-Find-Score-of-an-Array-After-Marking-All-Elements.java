class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        int n = nums.length;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];}
        );
        for(int i=0;i<n;i++){
            p.add(new int[]{nums[i],i});
        }

        while(!p.isEmpty()){
            int arr[] = p.poll();
            if(nums[arr[1]]!=-1){
                res+=arr[0];
                if(arr[1]-1>=0){
                    nums[arr[1]-1]=-1;
                }
                if(arr[1]+1<n){
                    nums[arr[1]+1]=-1;
                }
            }
        }
        return res;
    }
}