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
    ListNode res = new ListNode(0);
    ListNode dummy = res;
    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;
        ListNode temp = head;
        ListNode dup = head;
        Set<ListNode> set = new HashSet<>();
        while(temp!=null){
            c++;
            // System.out.println(temp.val);
            temp = temp.next;

            if(c==k){
                
                ListNode prev = null;
                ListNode temp1 = dup;
                ListNode nex ;
                int k1 = k;
                while(k1>0){
                    k1--;
                    nex = temp1.next;
                    temp1.next = prev;
                    prev = temp1;
                    temp1 = nex;    
                }

                while(prev!=null){
                    set.add(dummy);
                    dummy.next = prev;
                    dummy = dummy.next;
                    prev = prev.next;
                }
                c = 0;
                dup = temp;
            }

            
        }
        while(dup!=null){
            if(set.add(dup)){
                dummy.next = dup;
                dummy = dummy.next;
                dup = dup.next;
            }
            else{
                break;
            }
        } 
        return res.next;
    }
}
