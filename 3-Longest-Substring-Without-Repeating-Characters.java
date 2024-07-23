class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lpointer = 0;
        int bpointer = 0;
        int m=0;
        Set<Character> a = new HashSet<>();
        while(bpointer<s.length()){
            if(a.contains(s.charAt(bpointer))){
                m = Math.max(a.size(),m);
                a.remove(s.charAt(lpointer));
                lpointer++;
            }
            else{
              a.add(s.charAt(bpointer));
              bpointer++;
            }
        }
       
        m = Math.max(a.size(), m);
        return m;
    }
}