class Solution {
    public int minimumLength(String s) {
        int [] arr = new int[26];
        int l=0;
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
            if(arr[ch-'a']>2){
                arr[ch-'a'] = 1;
            }
        }
        for(int i : arr){
            l+=i;
        }
        return l;
    }
}