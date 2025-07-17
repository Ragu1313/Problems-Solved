class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            int no = num.charAt(i)-'0';
            while(k>0 && !st.isEmpty() &&  st.peek()>no){
                st.pop();k--;
            }
            st.push(no);
        }
        while(k-->0 && !st.isEmpty()){
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.pop()) );
        }
        int n = sb.length()-1;
        while(n>=0 && sb.charAt(n)=='0'){
            sb.deleteCharAt(n);
            n--;
        }
        if(sb.length()==0)  return "0";
        return sb.reverse().toString();
    }
}