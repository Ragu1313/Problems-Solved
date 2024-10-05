class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int arr[] = new int [26];
        int l = s1.length();
        for(int i=0;i<l;i++)
            arr[s1.charAt(i)-'a']++;
        
        int len = 0;
        for(int i=0;i<=s2.length()-l;i++){
            len = 0;
            int cnt[] = new int[26];
            for(int j=i;j<l+i;j++){
                char ch = s2.charAt(j);
                // System.out.print(ch+\ \);
                if(cnt[ch-'a']<arr[ch-'a'] && arr[ch-'a']>0){
                    // System.out.println(ch);
                    len++;
                    cnt[ch-'a']++;
                }
            }
            // System.out.println();
            if(len==l)  return true;
        }
        return false;
        
    }
}