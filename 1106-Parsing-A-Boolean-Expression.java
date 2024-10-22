class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> bool = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(char ch: expression.toCharArray()){
            if(ch=='(' || ch=='f' || ch=='t'){
                bool.push(ch);
                continue;
            }
            if(ch=='!' || ch=='&' || ch=='|'){
                op.push(ch);
                continue;
            }
            if(ch==')'){
                char currOp = op.pop();
                boolean res = false;
                if(currOp=='&'){
                    res=true;
                    while(bool.peek()!='('){
                        if(bool.pop()=='f'){
                            res=false;
                        }
                    }
                }
                else if(currOp=='|'){
                    res=false;
                    while(bool.peek()!='('){
                        if(bool.pop()=='t'){
                            res=true;
                        }
                    }
                }
                else if(currOp=='!'){
                    if(bool.pop()=='t') res=false;
                    else res=true;
                }
                if(bool.peek()=='(') bool.pop();
                if(res) bool.push('t');
                else bool.push('f');
            }
        }
        return (bool.pop()=='t')? true: false;
    }
}