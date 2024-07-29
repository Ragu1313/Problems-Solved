class Solution {
    public boolean checkValidString(String s) {
        int i;
        int open=0,c=0;
        for(char ch : s.toCharArray()){
           if(ch=='('){
                open++;
                c++;
           }
            else if(ch==')'){
                open--;
                c--;
            }
            else{
                open--;
                c++;
            }
            if(c<0){
                return false;
            }
            if(open<0)
                open = 0;
        }
        if(open==0)
            return true;
        return false;
        
    }
}