class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        Queue<Character> stack = new LinkedList<>();
        int flag = 0;
        int in = 0;
        if(s.length()==0)   return 0;
        if(s.charAt(0)=='-'  || s.charAt(0)=='+') {
            if(s.charAt(0)=='-') 
                flag = 1;
            
            in++;
        }
        for(int i=in;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9' ){
                if(stack.isEmpty() && s.charAt(i)=='0') continue;
                stack.add(s.charAt(i));
            }
            else{
                break;
            }
        }
        int res=0;
        while(!stack.isEmpty()){
            int digit = stack.poll()-'0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return flag==0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = (res*10)+digit;
        }
        if(flag==1) return -res;
        return res;
    }
}