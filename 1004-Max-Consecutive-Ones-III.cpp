class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int lpoi = 0;
        int rpoi = 0;
        int cnt = 0;
        // int temp = 0;
        int res = 0;
        if(k==0){
            res = 0;
            int temp = 0;
            for(int i=0;i<nums.size();i++){
                if(nums[i]==1){
                    temp++;
                    res = max(temp,res);
                }
                else{
                    temp = 0;
                }
            }
            return res;
        }
        while(rpoi<nums.size()){
            if(nums[rpoi]!=1){
                cnt++;
            }
            if(cnt==k+1){
                res = max(res,rpoi-lpoi);
                // if(nums[lpoi]==0){
                //     lpoi++;
                // }
                // else{
                    while(nums[lpoi]==1){
                        lpoi++;
                    }
                    lpoi++;
                // }
                cnt--;
            }
            rpoi++;
        }
        res = max(res,rpoi-lpoi);
        return res;
    }
};