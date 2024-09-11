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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        ListNode[] res = new ListNode[k];
        int count = 0;
        
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(count ==0)
            return res;
        int c = 0;;
        if(count<=k){
            ListNode next1 = head.next;
            for(ListNode i=head;i!=null;i=next1){
                next1 = i.next;
                i.next = null;
                res[c++] = i;
                k--;
            }
            if(k>0){
                while(k!=0){
                    res[c++]= null;
                    k--;
                }
            }
            return res;
        }
        int d =0;
        try{
        d = count/k;
        }catch(Exception e){}
        temp = head;
        int total = d*k;
        int diff = count - total;
        total = d;
        if(diff>0){
            diff--;
            total++;
        }
        // System.out.println(total);
        res[c++] = head;
        for(ListNode i=head;i!=null;i=temp){
            if(total==1 && i.next!=null){
                temp = i.next;
                i.next = null;
                res[c++] = temp;
                total = d;
                if(diff>0){
                    total = total+1;
                    diff--;
                }
            }
            else{
                total--;
                temp = i.next;
            }

        }
        return res;
    }
}