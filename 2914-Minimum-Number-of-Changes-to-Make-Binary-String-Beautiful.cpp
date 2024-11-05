class Solution {
public:
    int minChanges(string s) {
        int one  = 0;
        int zero = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            char ch = s[i];
            if(ch=='1'){
                if(zero%2==1){
                    res++;
                    zero=0;
                    one = 0;
                }
                else one++;   
            }
            else {
                if(one%2==1){
                    res++;
                    one=0;
                    zero = 0;
                    // continue;
                }
                else zero++;
                
            }
        }
        return res;
    }
};