class Solution {
    public int f(String s1,String s2){
        int n = Math.min(s1.length(),s2.length());
        int ind = 0;
        while(ind<n && s1.charAt(ind)==s2.charAt(ind)) ind++;
        return ind;
    }
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int arr[] = new int[n];
        // int pre = 0;
        arr[0] = 0;
        int pre[] = new int[n];
        int suf[] = new int[n];
        for(int i=0;i<n-1;i++){
            int temp = f(words[i],words[i+1]);
            pre[i] = temp; 
            if(i-1>=0)
            pre[i] = Math.max(pre[i-1],temp);
            arr[i] = temp;
        }
        suf[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            suf[i] = Math.max(suf[i+1],arr[i]);
        }
        int res[] = new int[n];
        if(1<n)
        res[0] = suf[1]; 
        for(int i=0;i<n-1;i++){
            if(i-2>=0)
            res[i] = pre[i-2]; 
            if(i+1<n){
                res[i] = Math.max(res[i],suf[i+1]);
            }
            if(i+1<n && i-1>=0)
            res[i] = Math.max(res[i],f(words[i-1],words[i+1]));
        }
        if(n-3>=0)
        res[n-1] = pre[n-3];
        return res;
    }
}