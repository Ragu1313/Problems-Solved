class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> a = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            int num=Integer.MIN_VALUE;
            String op = \\;
            try{
                num = Integer.parseInt(tokens[i]);
            }
            catch(Exception e){
                op = tokens[i];
            }
            if(num!=Integer.MIN_VALUE){
                a.push(num);
            }
            else{
                int temp1 = a.pop();
                int temp2 = a.pop();
                if(op.equals(\+\))
                    a.push(temp1+temp2);
                else if(op.equals(\-\))
                    a.push(temp2-temp1);
                else if(op.equals(\*\))
                    a.push(temp2*temp1);
                else
                    a.push(temp2/temp1);
            }
        }
        int res = a.pop();
        return res;
    }
}