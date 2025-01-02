class Solution {
    
    public String countAndSay(int n) {
        if(n==1)    return "1";
        // Map<String,String>
        String res = "1";
        for(int i=2;i<=n;i++){
            char prev= res.charAt(0);
            String temp = "";
            int cnt = 1;
            for(int j=1;j<res.length();j++){
                char ch = res.charAt(j);
                if(prev!=ch){
                    temp = temp+String.valueOf(cnt)+String.valueOf(prev);
                    prev = ch;
                    cnt = 0;
                }
                cnt++;
            }
            temp = temp+String.valueOf(cnt)+String.valueOf(prev);
            res = temp;
            // System.out.println(res);
        }
        return res;
    }
}