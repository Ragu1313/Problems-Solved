class Solution {
public:
    int trap(vector<int>& height) {
        // vector<int> front;
        int n = height.size();
        vector<int> end(height.size());
        end[n-1] = height[n-1];
        
        for(int i=n-2;i>=0;i--){
            end[i] = max(end[i+1],height[i]);
        }
        int res = 0;
        int left = 0;
        for(int i=0;i<n;i++){
            left = max(left,height[i]);
            res = res+min(left,end[i])-height[i];
        }
        return res;
    }
};