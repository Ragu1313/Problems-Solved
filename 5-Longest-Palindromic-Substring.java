class Solution {
    public String longest(int i,int j,String s,String lon){
        // int flag = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            if(j-i+1> lon.length()){
                lon = s.substring(i,j+1);
            }
            i--;
            j++;
            
            // flag = 1;
        }
        return lon;
    }
    public String longestPalindrome(String s) {
        String lon = \\;
        for(int i=0;i<s.length();i++){
            lon = longest(i,i,s,lon);
            lon = longest(i,i+1,s,lon);
        }
        return lon;
    }
}