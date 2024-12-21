/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node temp1 = new Node(-1);
        Node dup = temp1;
        Map<Node,Node> map = new HashMap<>();
        while(temp!=null){
            dup.next = new Node(temp.val);
            map.put(temp,dup.next);
            temp = temp.next;
            dup = dup.next;
        }
        Node temp2 = head;
        Node dup1 = temp1.next;
        while(dup1!=null){
            // if(map.get(temp2.random)!=null)
                dup1.random = map.get(temp2.random);
            // else
            dup1 = dup1.next;
            temp2 = temp2.next;
        }
        return temp1.next;
    }
}