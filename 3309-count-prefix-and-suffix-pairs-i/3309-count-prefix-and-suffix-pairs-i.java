class Solution {
    public boolean c(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2){
            return false;
        }
        for(int i=0;i<n1;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        n2--;
        for(int j=n1-1;j>=0;j--){
            if(s1.charAt(j)!=s2.charAt(n2--)){
                return false;
            }
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(c(words[i],words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}