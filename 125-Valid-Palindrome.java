class Solution {
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase();
        String b = a.replaceAll(\[^a-z^0-9]\,\\);
        String c = \\;
        int len = b.length();
        int i;
        for(i=len-1;i>=0;i--){
            c=c + b.charAt(i);
        }
        if(c.equals(b)){
            return true;
        }
        return false;
       
    }
}