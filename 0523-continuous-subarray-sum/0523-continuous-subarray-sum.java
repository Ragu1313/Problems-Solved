class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] rem=new int[n];
        for(int i=0;i<n;i++)rem[i]=nums[i]%k;
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=rem[i];
            int temp = sum%k;
            if(map.containsKey(temp)){
                int ind = map.get(temp);
                if(i-ind>1){
                    return true;
                }
            }
            else{
                map.put(temp,i);
            }
        }
        return false;
    }
}