class Solution {
public:
    string clearDigits(string s) {
        stack<char> s1;
        for(char ch : s){
            if(isdigit(ch)){
                s1.pop();
            }
            else{
                s1.push(ch);
            }
        }
        string res = "";
        while(!s1.empty()){
            res = s1.top()+res;
            s1.pop();
        }
        return res;
    }
};