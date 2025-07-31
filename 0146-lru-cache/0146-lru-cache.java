class Node{
    int val;
    Node prev;
    Node next;
    int key;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
class LRUCache {
    int capacity ; 
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity ;
        head.next = tail;
        tail.prev = head;
    }
    
    public void insertFirst(Node newNode){
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        map.put(newNode.key , newNode);
        if(map.size()==capacity+1)  removeLast();
    }

    public void removeLast(){
        Node prev = tail.prev;
        prev.prev.next = tail;
        tail.prev = prev.prev;
        map.remove(prev.key);
    }

    public void f(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        insertFirst(node);
    }

    public int get(int key) {
        if(map.get(key)!=null)  {
            f(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null) { 
            map.get(key).val = value;
            f(map.get(key)) ;
        }
        else
        insertFirst(new Node(key,value));
        return ;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */