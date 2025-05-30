class Node{
    String url;
    Node prev;
    Node next;
    public Node(String url){
        this.url = url;
        prev = null;
        next = null;
    }
}

class BrowserHistory {

    Node head ;
    Node cur ;
    public BrowserHistory(String homepage) {
        cur = new Node(homepage);
        head = cur;
    }
    
    public void visit(String url) {
        cur.next = new Node(url);
        cur.next.prev = cur;
        cur = cur.next;
    }
    
    public String back(int steps) {
        // Node temp = cur;
        while(steps-->0 && cur.prev!=null){
            cur = cur.prev;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        // Node temp = cur;
        while(cur.next!=null && steps-->0){
            cur = cur.next;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */