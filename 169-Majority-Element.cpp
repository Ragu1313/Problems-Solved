class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int,int> m;
        for(int i=0;i<nums.size();i++){
            m[nums[i]]++;
        }
        int maxi=0;
        int ele = 0;
        for(int i=0;i<nums.size();i++){
            if( m[nums[i]]>ele){
                ele = m[nums[i]];
                maxi = nums[i];
            }
        }
        return maxi;
    }
};