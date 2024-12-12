class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(n<=10){
            return new ArrayList<String>();
        }
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<10;i++){
            sb.append(s.charAt(i));
        }

        s1.add(sb.toString());        
        // int l = 0;
        int r = 10;
        while(r<n){
            sb.deleteCharAt(0);
            sb.append(s.charAt(r));
            if(!s1.add(sb.toString())){
                s2.add(sb.toString());
            }
            r++;
        }
        for(String i : s2){
            res.add(i);
        }
        return res;
    }
}