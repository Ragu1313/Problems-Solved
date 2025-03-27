class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int arr[] = new int[n+1];
        Map<Integer,Integer> map = new HashMap<>();
        int dominant = -1;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>=n/2){
                dominant = i;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(nums.get(i)==dominant){
                arr[i+1] = arr[i] + 1;
            }
            else{
                arr[i+1] = arr[i];
            }
        }
        for(int i=1;i<n;i++){
            int tempind = n-i;
            int nextcnt = arr[n]-arr[i];
            if(arr[i]>=(1+i-arr[i]) && nextcnt>=1+tempind-nextcnt){
                return i-1;
            }
        }
        return -1;

    }
}