class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int cnt = 0;
        int res = 0;
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i))){
                cnt++;
            }
        }
        res = cnt;
        for(int i=k;i<s.length();i++){
            if(set.contains(s.charAt(i-k))){
                cnt--;
            }
            if(set.contains(s.charAt(i))){
                cnt++;
            }
            res = Math.max(cnt,res);
        }
        return res;
    }
}