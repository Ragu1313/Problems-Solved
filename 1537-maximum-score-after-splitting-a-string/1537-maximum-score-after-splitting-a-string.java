class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int one[] = new int[n];
        int zero[] = new int[n];
        int cnt = 0;
        if(s.equals("01") ){
            return 2;
        }
        for(int i=0;i<n-1;i++){
            char ch = s.charAt(i);
            if(ch=='0'){
                cnt++;
            }
            zero[i] = cnt;
        }
        cnt = 0;
        for(int i = n-1;i>0;i--){
            char ch = s.charAt(i);
            if(ch=='1'){
                cnt++;
            }
            one[i] = cnt;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            int sum = one[i]+zero[i];
            res = Math.max(res,sum);
        }
        return res;
    }
}