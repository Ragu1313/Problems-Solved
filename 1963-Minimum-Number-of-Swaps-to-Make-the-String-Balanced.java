class Solution {
    public int minSwaps(String s) {
        int op=0;
        // int cl=0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                op--;
            }
            else{
                op++;
                if(res<op)  res = op;
            }
        }
        return (res+1)/2;
    }
}