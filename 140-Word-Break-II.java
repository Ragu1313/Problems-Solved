class Solution {
    Set<String> res = new HashSet<>();
    boolean check(int i,String s,String s2){
        if(s.substring(i,s.length()).length() < s2.length()){
            return false;
        }
        for(int ii=0;ii<s2.length();ii++){
            if(s2.charAt(ii)!=s.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
    public void f(int i,String s,String p,List<String> word){
        if(i==s.length()){
            res.add(p.trim());
            return ;
        }

        for(int ii=0;ii<word.size();ii++){
            if(s.charAt(i)==word.get(ii).charAt(0)){
                if(check(i,s,word.get(ii))){
                    f(i+word.get(ii).length(),s,p+\ \+word.get(ii),word);
                    
                }
            }
        }
        
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        f(0,s,\\,wordDict);
        List<String> res1 = new ArrayList<>();
        for(String i:res){
            res1.add(i);
        }
        return res1;
    }
}