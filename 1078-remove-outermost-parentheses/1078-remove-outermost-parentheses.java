class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int op = 0,cl = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')    op++;
            else    cl++;
            if(op==cl){
                int ind = i+1 - op-cl;
                // System.out.println(ind+ " "+i);
                for(int j = ind+1;j<i;j++){
                    sb.append(s.charAt(j));
                }
                op = 0;cl = 0;
            }
        }
        return sb.toString();
    }
}