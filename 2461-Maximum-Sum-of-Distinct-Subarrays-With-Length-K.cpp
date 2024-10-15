class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        long long res  = 0;
        long long sum = 0;
        for(int i=0;i<k;i++){
            m[nums[i]]++;
            sum = sum+nums[i];
        }
        if(m.size()==k){
            res = sum;
        }
        for(int i=k;i<nums.size();i++){
            m[nums[i]]++;
            m[nums[i-k]]--;
            sum = sum-nums[i-k]+nums[i];
            if(m[nums[i-k]]==0){
                m.erase(nums[i-k]);
            }
            if(m.size()==k){
                res = max(res,sum);
            }
        }
        return res;

    }
};