/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int helper(Node temp){
        Node node = temp;
        int res = 1;
        while(temp!=node.next){
            if(node.next==null)  return 0;
            node = node.next;
            
            res++;
        }
        return res;
    }
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        
        return helper(slow);
    }
}