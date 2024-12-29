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
   
    // public void f()

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode temp = root;
        // int 
        // ListNode
        int diff = right-left;
        if(diff==0) return head;
        ListNode dummy = null; 
        while(left-->0){
            dummy = temp;
            temp = temp.next;
        }
        ListNode last = temp;
        
        ListNode cur = temp.next;
        ListNode next = null;
        while(cur!=null && diff-->0){
            // System.out.println(cur.val);
            next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
            // if(diff==0) break;
        }
        ListNode dup = temp;
        dummy.next = temp;
        // while(dup.next!=null){
        //     dup = dup.next;
        // }
        last.next = cur;
        return root.next;


        // f(temp,right-left);
    }
}