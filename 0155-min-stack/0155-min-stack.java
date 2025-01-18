class MinStack {

    // Stack<int[]> s;
    ArrayList<int[]> arr;
    public MinStack() {
        // s = new Stack<>();
        arr = new ArrayList<>();
    }
    
    public void push(int val) {
        if(arr.size()!=0){
            int a[] = arr.get(arr.size()-1);
            arr.add(new int[]{val,Math.min(val,a[1])});
        }
        else{
            arr.add(new int[]{val,val});
        }
    }
    
    public void pop() {
        arr.remove(arr.size()-1);
    }
    
    public int top() {
        return arr.get(arr.size()-1)[0];
    }
    
    public int getMin() {
        return arr.get(arr.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */