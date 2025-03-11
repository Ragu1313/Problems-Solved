class Solution {
    public boolean f(int arr[]){
        return arr[0]>0 && arr[1]>0 && arr[2]>0;
    }
    public int numberOfSubstrings(String s) {
        int cnt[] = new int[3];
        char ch[] = s.toCharArray();
        int n = ch.length;
        int lpoi=0;
        int rpoi = 0;

        int res  = 0;
        while(rpoi<n){
            while(rpoi<n && !f(cnt)){
                cnt[ch[rpoi]-'a']++;
                rpoi++;
            }
            while(f(cnt)){
                res+=n-rpoi+1;
                cnt[ch[lpoi]-'a']--;
                lpoi++;
            }
        }
        return res;
        
    }
}