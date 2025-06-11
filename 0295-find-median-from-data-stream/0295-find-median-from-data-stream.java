class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(min.size()==max.size()){
            max.add(num);
            min.add(max.poll());
        }
        else{
            max.add(num);
            if(!min.isEmpty() && min.peek()<max.peek()){
                int temp = min.poll();
                min.add(max.poll());
                max.add(temp);
            }
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return (max.peek()+min.peek())/2.0;
        }
        return min.peek();
    }
}
