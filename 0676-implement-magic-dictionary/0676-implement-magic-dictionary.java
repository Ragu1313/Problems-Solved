class Trie{
    Trie arr[] ;
    boolean end;
    public Trie(){
        arr = new Trie[26];
        end = false;

    }
    public void put(char ch,Trie node){
        arr[ch-'a'] = node;
    }
    public boolean contain(char ch){
        return arr[ch-'a']!=null;
    }
    public Trie getNode(char ch){
        return arr[ch-'a'];
    }
}
class MagicDictionary {
    Trie head;
    public MagicDictionary() {
        head = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary){
            Trie temp = head;
            char ch[] = s.toCharArray();
            for(char c : ch){
                if(!temp.contain(c)){
                    temp.put(c,new Trie());
                }
                temp = temp.getNode(c);
            }
            temp.end = true;
        }
    }
    
    public boolean f(int inx,int flag ,String word,Trie node){
        if(inx==word.length()) return node.end && flag==1;

        if(node.contain(word.charAt(inx))){
            if( f(inx+1,flag,word,node.getNode(word.charAt(inx))) )
                return true;
        }
        if(flag==0){
            for(char c='a';c<='z';c++){
                if(c!=word.charAt(inx) && node.contain(c)){
                    if(f(inx+1,1,word,node.getNode(c)))  return true;
                }
            }
        }
        return false;
    }

    public boolean search(String searchWord) {
        return f(0,0,searchWord,head);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */