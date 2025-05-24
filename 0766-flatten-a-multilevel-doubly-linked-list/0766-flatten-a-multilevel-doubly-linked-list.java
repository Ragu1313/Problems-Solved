/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node f(Node head){
        // if(head==null)  return null;
        // Node temp = head.next;
        Node prev = head;
        while(head!=null && head.child==null){
            prev = head;
            head = head.next;
        }
        if(head!=null){
            Node end = f(head.child);
            if(head.next==null){
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                return end;
            }
            else{
                head.next.prev = end;
                end.next = head.next;
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                return f(end);
            }
        }
        else
        return prev;
    }
    public Node flatten(Node head) {
        Node temp = head;
        if(head==null)  return null;
        f(head);
        return temp;
    }
}