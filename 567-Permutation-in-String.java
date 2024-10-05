class Solution {
    public boolean check(int arr[],int cnt[]){
        for(int i=0;i<26;i++){
            if(arr[i]!=cnt[i])  return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int arr[] = new int [26];
        int cnt[] = new int[26];
        int l = s1.length();
        for(int i=0;i<l;i++)
            arr[s1.charAt(i)-'a']++;
        int len = 0;
        for(int i=0;i<l;i++){
            char ch = s2.charAt(i);
            cnt[ch-'a']++;
        }
        if(check(arr,cnt))
            return true;
        // int poin = 0;
        for(int i=l;i<s2.length();i++){
            char prev = s2.charAt(i-l);
            cnt[prev-'a']--;
            char ch = s2.charAt(i);
            cnt[ch-'a']++;
            if(check(arr,cnt))  return true;
        }
        return false;    
    }
}