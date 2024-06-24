public class Triee {
    public class Node{
        private Node [] links = new Node[26];
        private boolean flag=false;
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        void putChar(char ch,Node node){
            links[ch-'a']=node;
        }
        void setEnd(){
            flag=true;
        }
        boolean isEnd(){
            return flag;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        
    }
    Node head ;
    public Triee(){
        super();
        head = new Node();
    }
    public void insert(String s){
        Node node = head;
        int i;
        for(i=0;i<s.length();i++){
            if(!node.containsKey(s.charAt(i)))
                node.putChar(s.charAt(i),new Node());
            node=node.get(s.charAt(i));
        }
        node.setEnd();
    }
    public boolean search(String s){
        Node node = head;
        int i=0;
        for(i=0;i<s.length();i++){
            if(!node.containsKey(s.charAt(i)))
                return false;
            node=node.get(s.charAt(i));
        }
        
        return node.isEnd();   
    }
    public boolean startsWith(String s){
        Node node = head;
        int i;
        for(i=0;i<s.length();i++){
            if(!node.containsKey(s.charAt(i)))
                return false;
            node=node.get(s.charAt(i));
        }
        return node.isEnd()!=true;
    }
    public void display() {
        displayHelper(head, "");
    }

    private void displayHelper(Node node, String word) {
        if (node == null) {
            return;
        }
        if (node.isEnd()) {
            System.out.println(word);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.containsKey(ch)) {
                displayHelper(node.get(ch), word + ch);
            }
        }
    }
    public static void main(String[] args) {
        Triee t = new Triee();
        t.insert("ragu");
        t.insert("raj");
        t.insert("ra");
        t.insert("negha");
        t.insert("snega");
        System.out.println(t.search("r"));
        System.out.println(t.startsWith("rag"));
        t.display();
    }
}
