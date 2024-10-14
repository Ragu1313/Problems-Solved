class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
    
        sort(nums.begin(),nums.end());
        set<vector<int>> s ;
        for(int i=0;i<nums.size()-2;i++){
            int j = i+1;
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int r = nums.size()-1;
            while(j<r){
                int temp = nums[i]+nums[j]+nums[r];
                if(temp == 0){
                    s.insert(vector<int>{nums[i],nums[j],nums[r]});
                    j++;
                    r--;
                }
                else if(temp<0) j++;
                else    r--;
            }
        }
        vector<vector<int>> res(s.begin(),s.end());
        return res;
    }
};