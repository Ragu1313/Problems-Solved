class Solution {
    public boolean canConstruct(String s, int k) {
        int arr[] = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        if(s.length()<k){
            return false;
        }
        int cnt = 0;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1)    cnt++;
        }
        if(cnt>k){
            return false;
        }
        return true;
    }
}