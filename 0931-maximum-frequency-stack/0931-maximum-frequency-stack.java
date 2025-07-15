class Node{
    int val;
    int freq;
    // int time;
    List<Integer> li ;
    public Node(int val,int freq){
        this.val = val;
        this.freq = freq;
        // this.time = time;
        li = new ArrayList<>();
    }
}
class FreqStack {
    PriorityQueue<Node> p;
    Map<Integer,Node> map;
    int time ;
    public FreqStack() {
        time = 1;
        map = new HashMap<>();
        p = new PriorityQueue<>((a,b)->{
            if(b.freq!=a.freq) return b.freq - a.freq;
            return b.li.get(b.li.size()-1) - a.li.get(a.li.size()-1);
        });
    }
    
    public void push(int val) {
        Node temp = map.get(val);
        if(temp==null){
            temp = new Node(val,1);
            temp.li.add(time++);
            map.put(val,temp);
            p.add(temp);
            return ;
        }
        p.remove(temp);
        temp.freq = temp.freq+1;
        temp.li.add(time++);
        map.put(val,temp);
        p.add(temp);
    }
    
    public int pop() {
        Node temp = p.poll();
        temp.freq = temp.freq-1;
        if(temp.freq>0){
            // temp.time = time++;
            temp.li.remove(temp.li.size()-1);
            p.add(temp);
            map.put(temp.val,temp);
        }
    
        return temp.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */