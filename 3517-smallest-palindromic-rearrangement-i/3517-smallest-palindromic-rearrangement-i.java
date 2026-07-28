class Solution {
    public String smallestPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int arr[] = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        char rem = '#';
        for(int i=0;i<26;i++){
            int n = arr[i]/2;
            if(rem=='#' && arr[i]%2==1){
                rem = (char)(i+'a');
            }
            for(int j=0;j<n;j++){
                sb.append((char)(i+'a'));
            }
        }
        
        String s1 = sb.toString();
        if(rem!='#'){
            s1 = s1 + rem+"";
        }
        StringBuffer sb1 = sb.reverse();
        return s1+sb1.toString();
    }
}