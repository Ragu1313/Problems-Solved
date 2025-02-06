// #define ll long long ;
class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        int res = 0;
        map<int,int> m;
        int n = nums.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = nums[i]*nums[j];
                m[temp]++;
            }
        }
        // int res = 0;
        for(auto& [k,v] : m){
            // if(v>1){
                int temp = 4*v*(v-1);
                res = res + temp;
            // }
        }
        return res;
    }
};