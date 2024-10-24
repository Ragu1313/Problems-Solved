class Solution {
    public boolean check(int freq[],int cnt[]){
        for(int i=0;i<58;i++){
            if(freq[i]>cnt[i])
                return false;
        }
        return true;
    }
    // public int[] fun(int freq[],int cnt[]){
    //     int arr[] = new int[2];
    //     int mini = Integer.MAX_VALUE;
    //     int maxi = Integer.MIN_VALUE;
    //     for(int i=0;i<52;i++){
    //         if(freq[i]==1){
    //             mini = Math.min(mini,cnt[i]);
    //             maxi = Math.max(maxi,cnt[i]);
    //         }
    //     }
    //     arr[0] = mini;
    //     arr[1] = maxi;
    //     return arr;
    // }
    public String minWindow(String s, String t) {
        int [] arr = new int[58];
        for(char ch : t.toCharArray()){
            arr[ch-'A']++;
        }
        int t1 = 0;
        int t2 = 0;
        int diff = Integer.MAX_VALUE;
        int cnt[] = new int[58];
        int l = 0;
        int r = 0;
        // System.out.println('w'-'A');
        while(r<s.length()){
            char ch = s.charAt(r);
            cnt[ch-'A']++;
            r++;
            if(check(arr,cnt)){
                while(arr[s.charAt(l)-'A']==0){
                    cnt[s.charAt(l)-'A']--;
                    l++;
                }
                while(arr[s.charAt(l)-'A']<cnt[s.charAt(l)-'A']){
                    cnt[s.charAt(l)-'A']--;
                    l++;
                }
                if(r-l<diff){
                    t1 = l;
                    t2 = r;
                    diff = t2 - t1;
                }
            }
        }
        return s.substring(t1,t2);
        // return \\;
    }
}
