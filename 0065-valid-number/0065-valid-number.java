class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean exponentialSeen = false;
        boolean decimalSeen = false;
        boolean expBefore = false;
        boolean expAfter = true;
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(c>='0' && c<='9'){
                numberSeen = true;
                expAfter = true;
            }
            else if(c=='e' || c=='E'){
                if(!numberSeen || exponentialSeen){
                    return false;
                }
                exponentialSeen = true;
                expAfter = false;
            }
            else if(c=='+' || c=='-'){
                if(i!=0 && ch[i-1]!='e' && ch[i-1]!='E'){
                    return false;
                }
            }
            else if(c=='.'){
                if(decimalSeen || exponentialSeen)  return false;
                decimalSeen = true;
            }
            else{
                return false;
            }
        }
        return numberSeen && expAfter;
    }
}