class Node {
    int start;
    int end;
    Node left;
    Node right;
    public Node(){
        
    }
    public Node(int start,int end){
        this.start = start;
        this.end = end; 
        this.left = null;
        this.right = null;
    }
}



class MyCalendar {

    // private List<int []> arr;
    Node root;
    public MyCalendar() {
        // this.arr = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        if(root==null){
            root = new Node(start,end);
            return true;
        }
        Node cur = root;
        while(cur!=null){
            if(cur.start>=end){
                if(cur.left==null){
                    cur.left = new Node(start,end);
                    return true;
                }
                cur = cur.left;
            }
            else if(cur.end<=start){
                if(cur.right==null){
                    cur.right = new Node(start,end);
                    return true;
                }
                cur = cur.right;
            }
            else return false;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */