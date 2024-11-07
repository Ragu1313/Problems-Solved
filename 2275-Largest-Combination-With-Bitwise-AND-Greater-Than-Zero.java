class Solution {
    public int largestCombination(int[] arr) {
        int res[] = new int[26];
        for(int i=0;i<arr.length;i++){
            int k = Integer.bitCount(arr[i]);
            int c = 1;
            while(k>0){
                if((arr[i]&1) > 0){
                    k--;
                    res[c]++;
                }
                arr[i] = arr[i]>>1;
                c++;
            }
        }
        int maxi = 0;
        for(int i=0;i<26;i++){
            if(res[i]>maxi){
                maxi = res[i];
            }
        }
        return maxi;
    }
}