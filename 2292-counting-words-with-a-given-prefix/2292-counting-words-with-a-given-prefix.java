class Trie{
    Trie arr[] ;
    int end;
    public Trie(){
        arr = new Trie[26];
        end = 0;
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
    public void put(char ch ,Trie node){
        arr[ch-'a'] = node;
    }
}

class Solution {
    Trie root = new Trie();
    public void insert(String s){
        Trie temp = root;
        for(char ch : s.toCharArray()){
            if(!temp.contains(ch)){
                temp.put(ch,new Trie());
                // System.out.print(ch+" ");
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    public boolean check(String s1){
        Trie temp = root;
        for(char ch : s1.toCharArray()){
            // System.out.print(ch+ " ");
            if(!temp.contains(ch)){
                return false;
            }
            
            
            temp = temp.get(ch);
            if(temp.getEnd()){
                return true;
            }    
        }
        return false;
    }
    // public void print(){
    //     Trie temp = root;
    //     while(true){

    //     }
    // }
    public int prefixCount(String[] words, String pref) {
        insert(pref);
        // Trie temp = root;
        int res = 0;
        for(int i=0;i<words.length;i++){
            if(check(words[i])){
                res++;
            }
        }
        return res;
        
    }
}