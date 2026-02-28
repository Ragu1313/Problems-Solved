class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<a1.length;i++){
            sum+= (a1[i]-a2[i]);
            map.putIfAbsent(sum,i);
            res = Math.max(res,i-map.get(sum));
        }
        return res;
    }
}