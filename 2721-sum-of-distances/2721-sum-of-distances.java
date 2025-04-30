class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,Long> map = new HashMap<>();
        Map<Integer,Integer> cnt = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0L)+i);
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
        }
        long res[] = new long[n];
        Map<Integer,Long> map2 = new HashMap<>();
        Map<Integer,Integer> cnt2 = new HashMap<>();
        for(int i=0;i<n;i++){
            map2.put(nums[i],map2.getOrDefault(nums[i],0L)+i);
            cnt2.put(nums[i],cnt2.getOrDefault(nums[i],0)+1);
            // System.out.println(cnt2.get(nums[i])+" "+ map2.get(nums[i]));
            int leftfer = cnt2.get(nums[i])-1;
            long leftSum = map2.get(nums[i])-i;
            long left = Math.abs(leftSum-(i*1L*leftfer));
            int rightfer = cnt.get(nums[i]) - cnt2.get(nums[i]);
            long rightSum = map.get(nums[i]) - map2.get(nums[i]);
            
            long right = Math.abs( (i*1L*rightfer) - rightSum  );
            // System.out.println(left+" "+right+" leftSum "+left);
            res[i] = left+right;
        }
        return res;
    }
}