class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        vector<int> res(code.size(),0);
        if(k>0){
            int sum = 0;
            for(int i=1;i<k;i++){
                sum = sum+code[i];
            }
            int i = k;
            int c = 0;
            while(c<code.size()){
                i = i%code.size();
                sum = sum+code[i];
                cout<<i<<" "<<sum<<endl;
                res[c] = sum;
                if(c+1<code.size())
                sum = sum - code[c+1];
                i++;
                c++;
            }
           
        }
        else if(k<0){
            int k1 = - k;
            int i = 0;
            int j = code.size()-1;
            while(i<j){
                int temp = code[i];
                code[i] = code[j];
                code[j] = temp;
                i++;
                j--;
            }
            int sum = 0;
            for(int i=1;i<k1;i++){
                sum = sum+code[i];
            }
            i = k1;
            int c = 0;
            while(c<code.size()){
                i = i%code.size();
                sum = sum+code[i];
                res[c] = sum;
                if(c+1<code.size())
                sum = sum - code[c+1];
                i++;
                c++;
            }
            i = 0;
            j = code.size()-1;
            while(i<j){
                int temp = res[i];
                res[i] = res[j];
                res[j] = temp;
                i++;
                j--;
            }
        }
        return res;
    }
};