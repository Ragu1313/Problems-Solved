class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // while(!stack.isEmpty() && (ch=='B' || ch=='D'))
                if(!stack.isEmpty() && ((ch=='B' && stack.peek()=='A' ) ||( ch=='D' && stack.peek()=='C') ) ){
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
        }
        return stack.size();
    }
}