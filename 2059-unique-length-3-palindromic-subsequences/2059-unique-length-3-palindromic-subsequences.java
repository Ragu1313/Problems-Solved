class Solution {
    
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int arr[] = new int[26];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int rev = arr[ch-'a'];
            if(i!=rev &&rev!=-1){
                int cnt[] = new int[26];
                for(int j=i+1;j<rev;j++){
                    cnt[s.charAt(j)-'a']=1;
                }
                int sum = 0;
                for(int ii : cnt){
                    sum+=ii;
                }
                res+=sum;
            }
            arr[ch-'a']=-1;
        }
        return res;
    }
}