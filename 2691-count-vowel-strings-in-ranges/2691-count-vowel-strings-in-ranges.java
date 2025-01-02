class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int res[] = new int[n];
        int pre[] = new int[words.length];
        int cnt = 0;
        int i=0;
        for(String s : words){
            int n1 = s.length();
            char ch1 = s.charAt(0);
            char ch2 = s.charAt(n1-1);
            if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u'){
                if(ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u'){
                    cnt++;
                }
            }
            pre[i++] = cnt;
        }
        for(i=0;i<n;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int ans = pre[end];
            if(start!=0){
                ans-=pre[start-1];
            }
            res[i] = ans;
        }
        return res;
    }
}