class Solution {
public:
    void heapify(int i,int n,vector<int>& nums){
        int left = i*2+1;
        int right = i*2+2;
        int lar = i;
        if(left<n && nums[left]>nums[lar]){
            lar = left;
        }
        if(right<n && nums[right]>nums[lar]){
            lar = right;
        }
        if(lar!=i){
            int temp = nums[lar];
            nums[lar] = nums[i];
            nums[i] = temp;
            heapify(lar,n,nums); 
        }
    }
    int f(int n,int k,vector<int>& nums){
        for(int i=n/2-1;i>=0;i--){
            heapify(i,n,nums);
        }
        for(int i=n-1;i>=0;i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            if(--k==0){
                return nums[i];
            }
            heapify(0,i,nums);
        }
        return -1;
    }
    int findKthLargest(vector<int>& nums, int k) {
        return f(nums.size(),k,nums);
    }
};