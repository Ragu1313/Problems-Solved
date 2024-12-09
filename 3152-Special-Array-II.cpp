class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> arr;
        vector<bool> rs;
        arr.push_back(0);
        for(int i=1;i<nums.size();i++){
            int val=nums[i]&1;
            int val2=nums[i-1]&1;
            if(val!=val2){
                arr.push_back(0);
            }
            else
            arr.push_back(1);
        
        }
        for(int i=1;i<nums.size() ;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        for(int i=0;i<queries.size();i++){
            int v=arr[queries[i][0]]-arr[queries[i][1]];
            if(v!=0){
                rs.push_back(false);
            }
            else{
                rs.push_back(true);
            }
        }
        return rs;
        

    }
};