class Solution {

    public boolean insideBoundary(int i,int n){
        return i<n;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int cnt[] = new int[n];
        boolean ans[] = new boolean[n];
        int sum = 0;
        if(s.charAt(0)=='0'){
            ans[0] = true;
        }
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            sum += cnt[i];
            if(sum>0 && c=='0'){
                ans[i] = true;
            }
            if(ans[i] && c=='0'){
                if(insideBoundary(i+minJump,n)){
                    cnt[i+minJump]++;
                }
                if(insideBoundary(i+maxJump+1,n)){
                    cnt[i+maxJump+1]--;
                }
            }
            
        }
        return ans[n-1];
    }
}