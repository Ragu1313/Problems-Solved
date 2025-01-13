class Solution {
    public int minimumLength(String s) {
        int [] arr = new int[26];
        int l=0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            if(arr[s.charAt(i)-'a']>2){
                arr[s.charAt(i)-'a'] = 1;
            }
        }
        for(int i : arr){
            l+=i;
        }
        return l;
    }
}