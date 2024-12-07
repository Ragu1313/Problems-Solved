class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        int res = 0;
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(set.add(i)){
                cnt = cnt+i;
                if(cnt>maxSum){
                    break;
                }
                res++;
            }
        }
        return res;
    }
}