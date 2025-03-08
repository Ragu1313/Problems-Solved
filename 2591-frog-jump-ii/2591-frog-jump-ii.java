class Solution {
    public int maxJump(int[] stones) {
        int res = Integer.MIN_VALUE;
        int n = stones.length;
        int prev = stones[0];
        for(int i=2;i<n;i+=2){
            res = Math.max(stones[i]-prev,res);
            prev = stones[i];
        }
        prev = stones[0];
        for(int i=1;i<n;i+=2){
            res = Math.max(stones[i]-prev,res);
            prev = stones[i];
        }
        res = Math.max(res,stones[1]-stones[0]);
        res = Math.max(res,stones[n-1]-stones[n-2]);
        return res;
    }
}