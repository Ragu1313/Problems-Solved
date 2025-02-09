class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        long long res = 0;
        long long  n = nums.size();
        unordered_map<long long ,int> s;
        for(int i=0;i<n;i++){
            // s.insert(nums[i]-i);
            res += s[nums[i]-i];
            s[nums[i]-i]++;
            
        }
        return n*(n-1)/2 - res;
    }
};