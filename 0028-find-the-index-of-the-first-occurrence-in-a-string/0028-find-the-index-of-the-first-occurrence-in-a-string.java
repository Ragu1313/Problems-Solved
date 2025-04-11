class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = needle.length();
        int n2 = haystack.length();
        int lps[] = new int[n1];
        lps[0] = 0;
        int ind = 1;
        int prev = 0;
        while(ind<n1){
            if(needle.charAt(ind)==needle.charAt(prev)){
                lps[ind] = prev+1;
                ind++;
                prev++;
            }
            else {
                if(prev==0){
                    lps[ind] = 0;
                    ind++;
                }
                else {
                    prev = lps[prev-1];
                }
            }
        }
        int i = 0,j=0;
        while(i<n2){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j==0)   i++;
                else {
                    j = lps[j-1];
                }
            }
            if(j==n1){
                return i-n1;
            }
        }
        return -1;
    }
}