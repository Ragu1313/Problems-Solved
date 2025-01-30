class Node{
    // int key;
    int val;
    Node prev;
    Node next;
    int key;
    public Node(int key,int val){
        this.key = key;
        prev = null;
        next = null;
        this.val = val;
    }
}

class LRUCache {
    // Deque<Map<Integer,Integer>> dp = new LinkedList<>();
    Map<Integer,Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int cap ;
    public void insertFirst(int key,Node newNode){
        map.put(key,newNode);
        Node temp = head.next;
        temp.prev = newNode;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
    }
    public void delete(Node node){
        int key = node.key;
        map.remove(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // int capacity; 
    public LRUCache(int capacity) {
        // this.capacity = capacity;
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        Node temp = map.get(key);
        int val = map.get(key).val;
        delete(map.get(key));
        insertFirst(key,new Node(key,val));
        return val;
    }
    
    public void put(int key, int val) {
        if(map.get(key)!=null){
            delete(map.get(key));
        }
        if(cap==map.size())
        delete(tail.prev);
        insertFirst(key,new Node(key,val));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */