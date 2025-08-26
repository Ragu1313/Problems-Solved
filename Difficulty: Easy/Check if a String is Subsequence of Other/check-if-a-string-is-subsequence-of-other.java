class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int inx1 = 0;
        int inx2 = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        while(inx1<n1 && inx2<n2){
            if(s1.charAt(inx1)==s2.charAt(inx2)){
                inx1++;
            }
            inx2++;
        }
        return inx1==n1;
    }
};