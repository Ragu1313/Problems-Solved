class CustomStack {

    ArrayList<Integer> stack;
    int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayList<>();
    }
    
    public void push(int x) {
        if(stack.size()==maxSize)
            return ;
        stack.add(x);   
    }
    
    public int pop() {
        if(stack.size()==0){
            return -1;
        }
        int res = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return res;
    }
    
    public void increment(int k, int val) {
        int min = Math.min(k,stack.size());
        for(int i=0;i<min;i++){
            stack.set(i,stack.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */