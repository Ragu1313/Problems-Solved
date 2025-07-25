class Pair{
    String str;
    int val;
    public Pair(String str,int val){
        this.str = str;
        this.val = val;
    }
}
class Solution {
    public boolean isUpper(char ch){
        return   (ch>='A' && ch<='Z') ;
    }

    public boolean isLower(char ch ){
        return ch>='a' && ch<='z';
    }

    public boolean isDigit(char ch){
        return ch>='0' && ch<='9';
    }

    public String countOfAtoms(String formula) {
        Map<String,Integer> map = new HashMap<>();
        int n = formula.length();
        Stack<Pair> st = new Stack<>();
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while(right<n){
            // System.out.println(right);
            if(formula.charAt(right)=='('){
                st.add(new Pair(formula.charAt(right)+"",1 ) );
                right++;
                // continue;
            }
            else if(isUpper(formula.charAt(right)) ) {
                sb.append(formula.charAt(right));
                right++;
                while(right<n && isLower(formula.charAt(right)) ){
                    sb.append(formula.charAt(right));
                    right++;
                }
                // int cnt = 1;
                int temp = 0;
                while(right<n && isDigit(formula.charAt(right))){
                    temp = temp*10 + (formula.charAt(right)-'0');
                    right++;
                }
                if(temp==0){ 
                    temp = 1;
                    // right++;
                }
                st.add(new Pair(sb.toString(),temp));
                sb.setLength(0);
                
            }
            else if(formula.charAt(right)==')'){
                int temp = 0;
                right++;
                while(right<n &&  isDigit(formula.charAt(right)) ){
                    temp = temp*10 + (formula.charAt(right)-'0');
                    right++;
                }
                if(temp==0){  
                    temp = 1;
                    // right++;
                }
                Stack<Pair> tempst = new Stack<>();
                while( !st.isEmpty() &&  !st.peek().str.equals("(") ){
                    st.peek().val = st.peek().val*temp;
                    tempst.add(st.pop());
                }
                if(!st.isEmpty() && st.peek().str.equals("("))
                st.pop();
                while(!tempst.isEmpty()){
                    st.add(tempst.pop());
                }
                // System.out.println(right + ")");
            }
            // right++;
        }
        TreeMap<String,Integer> res = new TreeMap<>();
        while(!st.isEmpty()){
            res.putIfAbsent(st.peek().str,0);
            res.put(st.peek().str,st.peek().val + res.get(st.peek().str));
            st.pop();
        }
        sb.setLength(0);
        for(String k : res.keySet()){
            sb.append(k);
            if(res.get(k)>1)
            sb.append(String.valueOf(res.get(k)));
        }
        return sb.toString();
    }
}