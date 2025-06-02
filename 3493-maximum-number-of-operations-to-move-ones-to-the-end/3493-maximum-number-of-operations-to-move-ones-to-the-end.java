class Solution {
    public int maxOperations(String s) {
        // return 0;
        int n = s.length();
        int cnt = 0;
        int res = 0;
        int i=0;
        while(i<n){
            while(i<n && s.charAt(i)=='1'){
                cnt++;
                i++;
            }
            int flag = 0;
            while(i<n && s.charAt(i)=='0'){
                i++;
                flag = 1;
            }
            if(flag==1){
                res+=cnt;
            }
            // cnt = 0;
        }
        return res;
    }
}