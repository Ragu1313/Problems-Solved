class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        int mark[] = new int[2001];
        for(int i=0;i<n;i++){
            if(fronts[i]==backs[i]){
                mark[fronts[i]] = 1;
            }
        }
        int min = 3000;
        for(int i=0;i<n;i++){
            if(mark[fronts[i]]==0){
                min = Math.min(min,fronts[i]);
            }
            if(mark[backs[i]]==0){
                min = Math.min(min,backs[i]);
            }
        }
        return min==3000?0:min;
    }
}