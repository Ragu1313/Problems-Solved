class Solution {
    public boolean divideArray(int[] nums) {
        int cnt[] = new int[501];
        for(int i : nums){
            cnt[i]++;
        }
        for(int i : cnt){
            if(i%2==1)  return false;
        }
        return true;
    }
}