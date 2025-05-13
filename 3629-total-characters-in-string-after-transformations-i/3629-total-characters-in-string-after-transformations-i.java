class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long arr[] = new long[26];
        int mod = (int)(1e9+7);
        char ch[] = s.toCharArray();
        for(char c : ch){
            arr[c-'a']++;
        }
        while(t-->0){
            long prev = 0;
            long next = arr[0];
            for(int i=0;i<26;i++){
                next = arr[i];
                arr[i] = prev;
                prev = next;
            }
            arr[0] = (arr[0]+prev)%mod;
            arr[1] = (arr[1]+prev)%mod;
        }
        long res = 0;
        
        for(long i : arr){
            res = (res+i)%mod;
        }
        
        return (int)(res%mod);
    }
}