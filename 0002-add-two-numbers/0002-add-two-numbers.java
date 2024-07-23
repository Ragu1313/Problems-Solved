/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode head = new ListNode();    
    public ListNode tail = head;        
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int c=0;
       while(l1!=null || l2!=null || c!=0){
           if(l1!=null){
              c+=l1.val;
              l1 = l1.next;
           }
           if(l2!=null){
              c+=l2.val;
              l2 = l2.next;
           }
           ListNode temp = new ListNode(c%10);
           tail.next = temp;
           c = c/10;  
           tail = tail.next;
       }
       return head.next;
    }
    
}