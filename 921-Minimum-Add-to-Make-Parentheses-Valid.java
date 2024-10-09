class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch==')' ){
                if(stack.isEmpty() || stack.peek()!='(')
                    stack.push(')');
                else
                    stack.pop();
            }
            else{
                // po--;
                // if(Math.abs(po)>res)    res = po;   
                stack.push('(');
            }
        }
        return stack.size();
    }
}