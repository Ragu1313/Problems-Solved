class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> s = new HashSet<>();
        for(int i=0;i<allowed.length();i++)
            s.add(allowed.charAt(i));
        int res = 0;
        int flag =0;
        for(int i=0;i<words.length;i++){
            String temp = words[i];
            flag = 0;
            for(int j=0;j<temp.length();j++){
                if(!s.contains(temp.charAt(j))){
                    flag = 1;
                    break;
                }
            }
            if(flag==0)
                res++;
        }
        return res;
    }
}