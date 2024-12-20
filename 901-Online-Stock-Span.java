class StockSpanner {
    List<Integer> arr ;
    Stack<Integer> s;
    public StockSpanner() {
        arr = new ArrayList<>();
        s = new Stack();
    }
    
    public int next(int price) {
        int ind = arr.size();
        arr.add(price);
        // if(!s.isEmpty()){
        
        while(!s.isEmpty() && arr.get(s.peek())<=price){
            // System.out.println(price+" "+arr.get(s.pop()));
            s.pop();
        }
        int i = -1;
        if(!s.isEmpty()){
            i = s.peek();
        }
        s.push(ind);
        
        if(i!=-1){
            // System.out.println(ind-i);
            return ind-i;
        }
        // System.out.println(i +" "+ind);
        // System.out.println(ind+1);
        // System.out.println(ind+1);
        return ind+1;
        // }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */