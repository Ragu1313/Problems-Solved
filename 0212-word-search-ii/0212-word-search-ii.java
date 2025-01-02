class Trie{
    boolean end;
    Trie arr[];
    public Trie(){
        arr = new Trie[26];
    }
    public boolean getEnd(){
        return end;
    }
    public void setEnd(){
        end = true;
    }
    public void putChar(char ch,Trie node){
        arr[ch-'a'] = node;
    }
    public Trie get(char ch){
        return arr[ch-'a'];
    }
    public boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
}

class Solution {
    Set<String> res = new HashSet<>();
    Trie root;
    int v1[] = {0,-1,0,1};
    int v2[] = {1,0,-1,0};
    public void insert(String s1){
        Trie node = root;
        for(char ch : s1.toCharArray()){
            if(!node.contains(ch)){
                node.putChar(ch,new Trie());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public boolean check(int i,int j,int n,int m,char [][] board){
        if(i>=0 && i<n && j>=0 && j<m && board[i][j]!='.'){
            return true;
        }
        return false;
    }
    public void f(int i,int j,Trie node,String p,int n,int m,char board[][]){
        if(node.getEnd()){
            res.add(p);
        }
        for(int k=0;k<4;k++){
            int n1 = i+v1[k];
            int m1 = j+v2[k];
            if(check(n1,m1,n,m,board)){
                if(node.contains(board[n1][m1])){
                    char ch = board[n1][m1];
                    board[n1][m1] = '.';
                    f(n1,m1,node.get(ch),p+String.valueOf(ch),n,m,board);
                    board[n1][m1] = ch;
                }
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        for(String s : words){
            insert(s);
        }
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(root.contains(board[i][j])){
                    char ch = board[i][j];
                    board[i][j] = '.';
                    f(i,j,root.get(ch),String.valueOf(ch),n,m,board);
                    board[i][j] = ch;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(String s : res){
            ans.add(s);
        }
        return ans;
    }
}