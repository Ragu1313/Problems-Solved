class Solution {
public:
    int longestBeautifulSubstring(string word) {
        int cnt = 0;
        string s1 = "aeiou";
        int res = 0;
        int temp = 0;
        for(int i=0;i<word.size();i++){
            if( cnt==4 && s1[cnt]==word[i] ){
                temp++;
                cnt++;
                res = max(temp,res);
            }
            else if(s1[cnt]==word[i]){
                cnt++;
                temp++;
            }
            else if(cnt>0 && s1[cnt-1]==word[i]){
                temp++;
                if(cnt==5){
                    res = max(temp,res);
                }
            }
            else{
                cnt = 0;
                temp = 0;
                if(word[i]==s1[cnt]){
                    temp = 1;
                    cnt = 1;
                }
            }
        }
        return res;
    }
};