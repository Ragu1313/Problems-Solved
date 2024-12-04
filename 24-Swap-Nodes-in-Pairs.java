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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode();
        ListNode head2 = temp;
        if(head==null || head.next==null)
           return head;
        while(head!=null && head.next!=null){
            ListNode prev = head.next.next;
            temp.next = head.next;
            temp = temp.next;
            temp.next = head;
            temp = temp.next;
            head = prev;
        }
        if(head!=null && head.next==null){
            temp.next = head;
            temp = temp.next;
        }
        temp.next=null;
        return head2.next;
    }
}