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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)  return head;
        ListNode temp = head;
        ListNode temp1 = head.next;
        ListNode head2 = temp1;
        while(temp.next!=null && temp.next.next!=null){
            ListNode dup = temp.next;
            temp.next = dup.next;
            temp = temp.next;
            dup.next = temp.next;
        }
        // while(temp1.next!=null && temp1.next.next!=null ){
        //     ListNode dup = temp1.next;
        //     temp1.next = dup.next;
        //     temp1 = temp1.next;
        // }
        temp.next = head2;
        return  head;
    } 
}