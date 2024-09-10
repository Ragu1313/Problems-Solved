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
    public int gcd(int n1,int n2){
        int rem = n1%n2;
        while(rem!=0){
            n1 = n2;
            n2 = rem;
            rem = n1%n2 ;
        }
        return n2;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        System.out.println(gcd(18,6));
        ListNode cur = head.next;
        ListNode prev = head;
        if(cur==null)
        return head;
        while(cur!=null){
            ListNode temp1 = new ListNode(gcd(cur.val,prev.val));
            temp1.next = prev.next;
            prev.next = temp1;
            prev = prev.next.next;
            cur = cur.next;
        }
        return head;
    }
}