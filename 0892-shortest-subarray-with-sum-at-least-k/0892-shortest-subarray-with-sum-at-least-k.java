class Pair{
    long val;
    int ind;
    public Pair(long val,int ind){
        this.val = val;
        this.ind = ind;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> q = new LinkedList<>();
        long sum = 0;
        int res = Integer.MAX_VALUE;
        q.addLast(new Pair(0, -1));
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(!q.isEmpty() && sum<=q.peekLast().val){
                q.pollLast();
            }
            q.addLast(new Pair(sum,i));
            while(!q.isEmpty() && sum-q.peekFirst().val>=k){
                res = Math.min(res,i-q.peekFirst().ind);
                q.pollFirst();
            }

            
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}