class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int cnt[] = new int[26];
        int odd = 0;
        int even = n;
        for(int i=0;i<n;i++){
            cnt[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            if((cnt[s.charAt(i)-'a']&1)==1){
                odd = Math.max(cnt[s.charAt(i)-'a'],odd);
            }
            else{
                even = Math.min(cnt[s.charAt(i)-'a'],even);
            }
        }
        return odd-even;
    }
}