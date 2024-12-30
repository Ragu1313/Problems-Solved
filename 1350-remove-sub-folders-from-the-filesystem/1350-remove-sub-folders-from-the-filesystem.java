class Trie{
    Trie ch[];
    int flag;
    public Trie(){
        ch = new Trie[27];
        flag = 0;
    }
    public void setEnd(){
        flag = 1;
    }
    public boolean getEnd(){
        return flag==1;
    }
    public Trie getNode(char c){
        return ch[c-'`'];
    }
    public boolean contains(char c){
        return ch[c]!=null;
    }
    public void putChar(char c,Trie node){
        ch[c-'`'] = node;
    }
}

class Solution {
    Trie root;
    List<String> res = new ArrayList<>();
    public void insert(String s){
        Trie node = root;
        for(char ch : s.toCharArray()){
            if(!node.contains((char)(ch-'`'))){
                node.putChar(ch,new Trie());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }
    public void f(Trie node , String sb){
        if(node.getEnd()) {
            for(int i=1;i<27;i++){
                char ch = (char)(i);
                if(node.contains(ch)){
            
                    System.out.println(sb);
                    f(node.getNode((char)(ch+'`')),sb+String.valueOf((char)(ch+'`')));
                }
            }
            sb = sb.replace('`','/');
            res.add(sb);
            return ;
        }
        for(int i=0;i<27;i++){
            char ch = (char)(i);
            if(node.contains(ch)){
                // System.out.println(sb);
                f(node.getNode((char)(ch+'`')),sb+String.valueOf((char)(ch+'`')));
            }
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        root = new Trie();
        for(int i=0;i<folder.length;i++){
            String s1 = folder[i];
            s1 = s1.replace('/','`');
            insert(s1);
        }
        for(int i=0;i<27;i++){
            char ch = (char)(i);
            if(root.contains(ch)){
                System.out.println("Hi");
                f(root.getNode((char)(ch+'`')),String.valueOf((char)(ch+'`')));
            }
        }
        return res;
    }
}