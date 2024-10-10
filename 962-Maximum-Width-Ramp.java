class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0;i<nums.length;i++){
            if(nums[stack.peek()]>=nums[i]){
                stack.push(i);
            }
        }
        int ans = 0;
        int n = stack.peek();
        // int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }

        return ans;
            // ans = Math.max(ans,res);
        // }
        // return ans;
    }
}