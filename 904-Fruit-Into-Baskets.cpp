class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        map<int,int> m;
        
        int lpointer = 0;
        int res = 0;
        for(int i=0;i<fruits.size();i++){
            m[fruits[i]] = i;
            if(m.size()<3){
                res = max(res,i-lpointer+1);
            }
            else{
                int index = INT_MAX;
                int element = INT_MAX;
                for(auto it = m.begin();it!=m.end();it++){
                    if(it->second < index){
                        index = it->second;
                        element = it->first;
                        lpointer = index+1;
                    }
                }
                m.erase(element);
            }
        }
        return res;
    }
};