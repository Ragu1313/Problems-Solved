class Solution {
    
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
         for (int i=0; i <n; i++)
        {
            int prefix = 0;
            for (int j = i; j < n; j++) {
                prefix += nums[j];
                res.add(prefix);
            }
        }
        Collections.sort(res);
        // System.out.println(res.toString());
        int ans= 0;
        for(int i=left-1;i<right;i++){
            ans+=res.get(i);
            ans = ans%1000000007;
        }
        return ans%1000000007;
    }
}