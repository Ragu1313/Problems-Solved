class Trie{
    Trie arr[] ;
    int end ;
    public Trie(){
        arr = new Trie[26];
        end = 0;
    }
    public void put(char ch,Trie node){
        arr[ch-'a'] = node;
    }
    public Trie get(char ch){
        return arr[ch-'a'];
    }
    public boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    public void setEnd(){
        end = 1;
    }
    public boolean getEnd(){
        return end==1;
    }
}
class Solution {
    Trie root = new Trie();
    
    public void build(String s){
        Trie temp = root;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!temp.contains(ch)){
                temp.put(ch,new Trie());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    // public void print(){
    //     Trie temp = root;
    //     for(){

    //     }
    // }
    public String longest(String s){
        
       StringBuilder sb = new StringBuilder();
        Trie temp = root;
        int n = s.length();
       for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            // System.out.print(ch+" ");
            temp = temp.get(ch);
            if(!temp.getEnd()){
                break;
            }
            sb.append(ch);
            
            // else 
       }
       return sb.toString();
    }
    public String longestWord(String[] words) {
        // Arrays.sort(words);
        for(String s : words){
            build(s);
        }
        String res = "";
        for(String s : words){
            String temp = longest(s);
            if(temp.length()>res.length()){
                res = temp;
            }
            else if(res.length()==temp.length()){
                if(res.compareTo(temp)>0){
                    res = temp;
                }
            }
        }
        return res;
    }
}