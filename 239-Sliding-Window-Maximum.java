// class Node{
//     // Node left;
//     Node next;
//     int data;
//     public Node(int data){
//         this.data = data;
//         this.next = null;
//     }
//     public Node(){
//         super();
//     }
// }

class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int arr[] = new int[nums.length-k+1];
        int c = 0;
        // for(int i=0;i<k;i++){
        //     if(deque.isEmpty()){
        //         deque.add(nums[i]);
        //     }
        //     else if(deque.peekLast()<nums[i]){
        //         // System.out.println(1);
        //         while(!deque.isEmpty() && deque.peekLast()<=nums[i]){
        //             // System.out.println(2);
        //             deque.removeLast();
        //         }
        //         deque.add(nums[i]);
        //     }
        //     else{
        //         deque.add(nums[i]);
        //         // System.out.println(deque.toString());
        //     }
        // }
        // System.out.println(deque.toString());
        // arr[c++] = deque.peekFirst();
        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.add(i);
            if(i+1>=k)  arr[c++] = nums[deque.peekFirst()];
        }
        // System.out.println(deque.toString());
        return arr;
        
    }
}