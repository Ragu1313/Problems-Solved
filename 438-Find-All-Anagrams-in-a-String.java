class Solution {
    public boolean check(int arr[],int cnt[]){
        for(int i=0;i<26;i++){
            if(arr[i]!=cnt[i])  return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if(p.length()>s.length()){
            return res;
        }
        int [] arr = new int[26];
        int [] cnt = new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        int l = p.length();
        if(Arrays.equals(arr,cnt))  res.add(0);
        for(int i=p.length();i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
            cnt[s.charAt(i-l)-'a']--;
            if(check(arr,cnt)){
                // System.out.println(i-l+1);
                res.add(i-l+1);
            }
                
        }
        return res;
    }
}