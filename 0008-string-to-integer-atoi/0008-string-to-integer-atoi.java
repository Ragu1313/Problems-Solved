class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        s = s.trim();
        // System.out.println(s);
        int n = s.length();
        boolean sign = true;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-') ){
            if(s.charAt(i)=='-')  sign  = false;
            i++;
        }
        while(i<n &&  ((s.charAt(i)>='1' && s.charAt(i)<='9') || s.charAt(i)=='0')  ){
            sb.append(s.charAt(i));
            i++;
        }
        s = sb.toString();
        sb.setLength(0);
        n = s.length();
        i = 0;
        while(i<n && s.charAt(i)=='0') i++;
        s = s.substring(i,n);
        if(s.length()==0) return 0;
        if(s.length()>10)  {
            if(!sign)  return Integer.MIN_VALUE; 
            return Integer.MAX_VALUE;
        }
        
        long res = 0L;
        // System.out.println(sb.toString());
        res = Long.parseLong(s);
        if(!sign) res = -res;
        if(res<Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        if(res>Integer.MAX_VALUE)  return Integer.MAX_VALUE;
        return (int)(res);
    }
}