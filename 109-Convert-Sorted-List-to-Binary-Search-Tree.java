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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode a;
    public TreeNode insert(int low,int high,List<Integer> arr){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode temp = new TreeNode(arr.get(mid));
        temp.left = insert(low,mid-1,arr);
        temp.right = insert(mid+1,high,arr);
        return temp;
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head!=null)
        {
            arr.add(head.val);
            head = head.next;
        }
        a = insert(0,arr.size()-1,arr);
        return a;
    }
}