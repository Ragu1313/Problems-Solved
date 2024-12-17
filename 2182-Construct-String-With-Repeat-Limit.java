class Solution {
    public String repeatLimitedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        int i=25;
        char prev = '_';
        while(i>0){
            while(i>=0 && arr[i]==0)    i--;
            if(i==-1)   break;
            int min = Math.min(k,arr[i]);
            char ch = (char)(i+97);
            if(ch==prev){
                int j = i-1;
                while(j>=0 && arr[j]==0)    j--;
                if(j==-1)   break;
                prev = (char)(j+97);
                arr[j]-=1;
                sb.append(prev);
                
            }
            prev = (char)(i+97);
            arr[i]-=min;
            while(min-->0){
                sb.append(prev);
            }
        }
        return sb.toString();
    }
}