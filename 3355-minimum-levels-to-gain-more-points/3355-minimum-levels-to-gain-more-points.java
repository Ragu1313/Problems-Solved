class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int pre[] = new int[n];
        // Math.pow((int)(1e15),(int)(1e15));
        int prev = 0;
        // pre[0] = possible[0]==1?1:-1;
        for(int i=0;i<n;i++){
            if(possible[i]==1){
                pre[i] = 1+prev;
            }
            else{
                pre[i] = prev-1;
            }
            prev = pre[i];
        }
        for(int i=0;i<n-1;i++){
            // System.out.println(pre[i]);
            if(pre[n-1]-pre[i]<pre[i]) return i+1;
        }
        return -1;
    }
}