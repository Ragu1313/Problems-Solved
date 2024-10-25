class Trie{
    Trie [] ch;
    int flag = 0;
    Trie(){
        this.ch = new Trie[256];
    }
    public Trie get(char c){
        return ch[c];
    }
    public void putChar(char c,Trie node){
        ch[c] = node;
    }
    public boolean isEnd(){
        return flag==1;
    }
    public void setEnd(){
        flag = 1;
    }
    public boolean contains(char c){
        return ch[c]!=null;
    }
}

class Solution {
    
    public void insert(String s,Trie trie){
        Trie temp = trie;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!temp.contains(ch)){
                temp.putChar(ch,new Trie());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    public void ruc(Trie trie,String s,List<String> res){
        if(trie.isEnd()){
            res.add(s);
            for(int i=97;i<125;i++){
                char ch = (char)i;
                if(trie.contains(ch)){
                    ruc(trie.get(ch),s+String.valueOf(ch),res);
                }
            }
            return ;
        }
        for(int i=0;i<256;i++){
            char ch = (char)i;
            if(trie.contains(ch)){
                ruc(trie.get(ch),s+String.valueOf(ch),res);
            }
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for(int i=0;i<folder.length;i++){
            String s = folder[i];
            insert(s,trie);
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<256;i++){
            char ch = (char)i;
            if(trie.contains(ch)){
                ruc(trie.get(ch),String.valueOf(ch),res);
            }
        }
        return res;
    }
}