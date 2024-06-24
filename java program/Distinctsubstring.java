class Tri{
    class Node{
        Node link[] = new Node[26];
        public void put(char ch,Node node){
            link[ch-'a']=node;
        }
        public Node get(char ch){
            return link[ch-'a'];
        }
        public boolean contain(char ch){
            return link[ch-'a']!=null;
        }
    }
    Node head;
    public Tri(){
        head = new Node();
    }
    public int insert(String word){
        int c=0;
        int i,j;
        int n = word.length();
        for(i=0;i<n;i++){
            Node node = head;
            for(j=i;j<n;j++){
                if(!node.contain(word.charAt(j))){
                    node.put(word.charAt(j),new Node());
                    c++;
                }
                node = node.get(word.charAt(j));
            }
        }
        c=c+1;
        return c;
    }
}

public class Distinctsubstring {
    public static void main(String[] args) {
        Tri t = new Tri();
        String s = "abab";
        System.out.println(t.insert(s));
    }
}
