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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++)
            s.add(nums[i]);
        ListNode temp = new ListNode();
        ListNode head2 = temp;
        while(head!=null){
            if(!s.contains(head.val)){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return head2.next;
    }
}