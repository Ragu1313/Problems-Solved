class Solution {
    public int longestKSubstr(String s, int k) {
        int arr[] = new int[26];
        int temp = 0;
        int res = -1;
        int right = 0;
        int left = 0;
        for(char c : s.toCharArray()){
            if(arr[c-'a']==0){
                temp++;
            }
            arr[c-'a']++;
            while(temp>k){
                arr[s.charAt(left)-'a']--;
                if(arr[s.charAt(left)-'a']==0){
                    temp--;
                }
                left++;
            }
            if(temp==k){
                res = Math.max(right-left+1,res);
            }
            right++;
        }
        return res;
    }
}