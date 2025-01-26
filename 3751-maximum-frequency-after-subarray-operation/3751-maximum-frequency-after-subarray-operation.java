class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int pre[] = new int[n];
        int c =0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]==k)  c++;
            pre[i] = c;
            set.add(nums[i]);
        }
        if(n==pre[n-1])   return n;
        int res = 0;
        for(int i: set){
            int ele = 0;
            int cnt = 0;
            int l = 0,r=0;
            while(r<n){
                if(nums[r]==k)  cnt--;
                else if(nums[r]==i)  {
                    cnt++;ele++;
                }
                int front = 0;
                int back = pre[n-1] - pre[r];
                if(l-1>=0)  front = pre[l-1];
                res = Math.max(res,ele+front+back);
                if(cnt<=0){
                    cnt = 0;
                    l = r+1;
                    ele = 0;
                }
                r++;
            }
        }
        return res;
    }
}