class Trie{
    Trie arr[] ;
    boolean end;
    public Trie(){
        arr = new Trie[26];
        end = false;
    }
    public void putChar(char ch,Trie node){
        arr[ch-'a'] = node;
    }
    public boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    public Trie getNode(char ch){
        return arr[ch-'a'];
    }
    
}
class WordDictionary {
    Trie head ;
    public WordDictionary() {
        head = new Trie();
    }
    
    public void addWord(String word) {
        char ch[] = word.toCharArray();
        Trie temp = head;
        for(char c : ch){
            if(!temp.contains(c)){
                temp.putChar(c,new Trie());
            }
            temp = temp.getNode(c);
        }
        temp.end = true;
    }
    
    public boolean search(String word) {
        Trie temp = head;
        return f(0,word,temp);
    }

    public boolean f(int inx,String word,Trie head){
        if(inx==word.length())  return head.end;
        if(word.charAt(inx)=='.'){
            for(char c='a';c<='z';c++){
                if(head.contains(c)){
                    if(f(inx+1,word,head.getNode(c)))  return true;
                }
            }
            
        }
        else{
            if(head.contains(word.charAt(inx))){
                return f(inx+1,word,head.getNode(word.charAt(inx)));
            }
           
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */