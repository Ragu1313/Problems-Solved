class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        // if(k>nums.size())   return ;
        k = k%nums.size();
        int ind = nums.size()-k;
        int c = 0;
        vector<int> res;
        for(int i=ind;i<nums.size();i++){
            res.push_back(nums[i]);
        }
        for(int i=0;i<ind;i++){
            res.push_back(nums[i]);
        }
        for(int i=0;i<nums.size();i++){
            nums[i] = res[i];
        }
    }
};