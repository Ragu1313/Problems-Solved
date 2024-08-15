/*

Add 1 to a Linked List Number
Difficulty: MediumAccuracy: 31.91%Submissions: 223K+Points: 4
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 105
*/

class Solution {
    Node reverse(Node root){
        Node prev = null;
        // Node current = root;
        Node next1 = null;
        while(root!=null){
            next1 = root.next;
            root.next = prev;
            prev = root;
            root = next1;
        }
        return prev;
    }
   
    public Node addOne(Node head) {
    //   ArrayList<Integer> a = new ArrayList<>();
        head = reverse(head);
        Node node = head;
        Node prev = null;
        int c = 1;
        while(node!=null){
            int sum = node.data+c;
            c = sum>9?1:0;
            sum = sum%10;
            node.data = sum;
            prev = node;
            node = node.next;
            
        }
        if(c==1){
            prev.next = new Node(1);
            prev = prev.next;
            prev.next = null;
        }
        head = reverse(head);
        return head;
    }
}
