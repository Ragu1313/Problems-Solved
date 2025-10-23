class Solution {
    public int[] f(int ind,String s){
        // int ind = 0;
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';
        int num = 0;
        int res = 0;
        // System.out.println(n);
        while(ind<n){
            char temp = s.charAt(ind);
            
            if(temp=='('){
                // System.out.println("Calling other function "+ind);
                int dup[] = f(ind+1,s);
                if(sign=='/' || sign=='*'){
                    st.push(st.pop()/dup[0]);
                }
                else {
                    if(sign=='-') dup[0] = dup[0]*-1;
                    st.push(dup[0]);
                }
                ind = dup[1];
                sign = '+';
                // System.out.println(dup[0]+" "+ind);
                num = 0;
                continue;
            }
            
            if(temp>='0' && temp<='9'){
                num = num*10 + (temp-'0');
            }
            if(ind==n-1 || temp=='+' || temp=='-' || temp=='/' || temp=='*'){
                // System.out.println();
                if(sign=='/' || sign=='*'){
                    st.push(st.pop()/num);
                }
                else {
                    if(sign=='-') num = num*-1;
                    st.push(num);
                }
                if(temp=='+' || temp=='-' || temp=='/' || temp=='*'){
                    sign = temp;
                }
                else{
                    sign = '+';
                }
                num = 0;
            }
            if(temp==')'){
                if(sign=='/' || sign=='*'){
                    st.push(st.pop()/num);
                }
                else {
                    if(sign=='-') num = num*-1;
                    st.push(num);
                }
                if(temp=='+' || temp=='-' || temp=='/' || temp=='*'){
                    sign = temp;
                }
                else{
                    sign = '+';
                }
                num = 0;
                ind++;
                break;
            }
            
            ind++;
        }
        // System.out.println(ind);
        while(!st.isEmpty()){
            int dup = st.pop();
            // System.out.println(dup);
            res += dup;
        }
        // System.out.println("returning from function result "+res+" ind :"+ind);
        return new int[]{res,ind};
    }
    public int calculate(String s) {
        
        int dup[] = f(0,s);
        return dup[0];
    }
}