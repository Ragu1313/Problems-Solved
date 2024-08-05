class Solution {
    public void part(int index,String s,List<List<String>> res,List<String> p){
        if(index==s.length()){
            res.add(new ArrayList<>(p));
            return ;
        }
        for(int i=index;i<s.length();i++){
            if(palindrome(s,index,i)){
                p.add(s.substring(index,i+1));
                part(i+1,s,res,p);
                p.remove(p.size()-1);
            }
        }
    }
    public boolean palindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> a = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        part(0,s,res,a);
        return res;
    }
}