class Solution {
    public static  boolean check(int cnt[],int fre[]){
        for(int i=0;i<26;i++){
            if(cnt[i]<fre[i])  return false;
        }
        return true;
    }
    public static String smallestWindow(String s, String p) {
        int cnt[] = new int[26];
        int fre[] = new int[26];
        for(char ch : p.toCharArray()){
            fre[ch-'a']++;
        }
        char ch[] = s.toCharArray();
        int right = 0;
        int left = 0;
        String res = new String(s+"as");
        while(right<ch.length){
            cnt[ch[right]-'a']++;
            while(check(cnt,fre)){
                String temp = s.substring(left,right+1);
                if(res.length()>temp.length()){
                    res = temp;
                }
                cnt[ch[left]-'a']--;
                left++;
            }
            right++;
        }
        return res.length()<=s.length()?res:"";
    }
}