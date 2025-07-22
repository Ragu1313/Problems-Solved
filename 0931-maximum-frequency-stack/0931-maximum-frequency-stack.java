// class Node{
//     int val;
//     // int time;
//     List<Integer> li ;
//     public Node(int val,int freq){
//         this.val = val;
//         this.freq = freq;
//         // this.time = time;
//         li = new ArrayList<>();
//     }
// }
class FreqStack {
    Map<Integer,Integer> map ;
    Map<Integer,Stack<Integer>> map2;
    int freq = 0;
    public FreqStack() {
       map = new HashMap<>();
       map2 = new HashMap<>();
    }
    
    public void push(int val) {
        int tempfreq = 0;
        if(map.get(val)!=null){
            tempfreq = map.get(val);
        }
        tempfreq++;
        map.put(val,tempfreq);
        if(map2.get(tempfreq)==null){
            map2.put(tempfreq , new Stack<>());
        }
        map2.get(tempfreq).add(val);
        if(freq<tempfreq){
            freq = tempfreq;
        }
    }
    
    public int pop() {
        int res = map2.get(freq).pop();
        map.put(res,freq-1);
        if(map2.get(freq).size()==0)  freq--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */