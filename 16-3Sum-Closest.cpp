class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        // set<vector<int>> s;
        int res = nums[0] + nums[1] + nums[2];;
        // for(auto i : nums)
        //     cout<<i<<\ \;
        for(int i=0;i<=nums.size()-2;i++){
            // if(i!=0 && nums[i-1]==nums[i])  continue;
            int l = i+1;
            int r = nums.size()-1;
            while(l<r){
                int temp = nums[i]+nums[l]+nums[r];
                if(temp == target){
                    return temp;
                }
                if(abs(temp-target)<abs(res-target) ){
                    res = temp;
                }
                else if(temp<target)    l++;
                else    r--;
            }
        }
        return res;
    }
};