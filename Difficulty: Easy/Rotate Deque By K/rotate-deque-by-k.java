class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        if(type==1){
            k = k%dq.size();
            while(k-->0){
                dq.addFirst(dq.pollLast());
            }
        }
        else{
            k = k%dq.size();
            while(k-->0){
                dq.addLast(dq.pollFirst());
            }
        }
        return ;
    }
}