class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        // sort(digits.begin(),digits.end());
        vector<int> ans ;
        int n = digits.size();
        set<int> res ;
        // for(int i : digits){
        //     if((i&1)==0){
        //         even.push_back(i);
        //     }
        // }
        for(int i=0;i<n;i++){
            if(digits[i]==0)    continue;
            for(int j=0;j<n;j++){
                if(digits[j]%2==1 || i==j)    continue;
                for(int k=0;k<n;k++){
                    if(i==k || j==k)    continue;
                    int temp = (digits[i]*100) + (digits[k]*10)+digits[j];
                    res.insert(temp);
                }
            }
        }
        for(int i : res){
            ans.push_back(i);
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};