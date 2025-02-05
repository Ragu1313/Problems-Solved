class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int n = s1.size();
        if(s1.size()!=s2.size())    return false;
        int cnt = 0;
        char t1 = '#';
        char t2 = '#';
        char t3 = '#';
        char t4 = '#';
        for(int i=0;i<n;i++){
            if(s1[i]!=s2[i]){
                if(cnt==0)  {
                    t1 = s1[i];
                    t3 = s2[i];
                }
                else  {
                    t2 = s2[i];
                    t4 = s1[i];
                }  
                // t1 = s1[i];
                cnt++;
            }
        }
        if((cnt==2 || cnt==0) && t1==t2 && t3==t4)  return true;;
        return false;
    }
};