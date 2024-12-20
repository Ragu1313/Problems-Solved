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
    public ListNode partition(ListNode head, int x) {
        ListNode head2 = new ListNode(0);
        ListNode temp2 = head2;
        ListNode temp3 = new ListNode(0);
        ListNode head3 = temp3;
        while(head!=null){
            if(head.val<x){
                temp2.next = head;
                temp2 = temp2.next;
            }
            else{
                temp3.next = head;
                temp3 = temp3.next;
            }
            head = head.next;
        }
        if(temp3!=null){
            temp2.next = head3.next;
            temp3.next = null;
        }
        else{
            temp2.next=null;
        }
        return head2.next;
    }
}