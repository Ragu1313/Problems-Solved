class SpecialQueue {
    
    Queue<Integer> queue ;
    Deque<Integer> min ;
    Deque<Integer> max ;
    public SpecialQueue() {
         queue = new LinkedList<>();
         min = new ArrayDeque<>();
         max = new ArrayDeque<>();
         
    }

    public void enqueue(int x) {
        queue.offer(x);
        while(!min.isEmpty() && min.peekLast()>x){
            min.pollLast();
        }
        min.add(x);
        while(!max.isEmpty() && max.peekLast()<x){
            max.pollLast();
        }
        max.add(x);
    }

    public void dequeue() {
        int temp = queue.poll();
        if(min.peekFirst()==temp){
            min.pollFirst();
        }
        if(max.peekFirst()==temp){
            max.pollFirst();
        }
    }

    public int getFront() {
        if(!queue.isEmpty())
        return queue.peek();
        return -1;
    }

    public int getMin() {
        if(!min.isEmpty())
        return min.peekFirst();
        return -1;
    }

    public int getMax() {
        if(!max.isEmpty())
        return max.peekFirst();
        return -1;
    }
}