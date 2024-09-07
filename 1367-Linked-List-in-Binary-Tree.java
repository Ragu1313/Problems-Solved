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
    boolean flag = false;

    public void inorder(TreeNode head, int value, ListNode root) {
        if (head != null && !flag) { // stop recursion if flag is set to true
            inorder(head.left, value, root);
            if (head.val == value && check(head, root)) {
                flag = true; // mark flag to true if subpath found
                return;
            }
            inorder(head.right, value, root);
        }
    }

    public boolean check(TreeNode head, ListNode root) {
        if (head == null || root == null) return root == null;

        if (head.val == root.val) {
            if (root.next == null) return true; // reached the end of ListNode

            int nextVal = root.next.val;
            boolean leftCheck = (head.left != null && head.left.val == nextVal) && check(head.left, root.next);
            boolean rightCheck = (head.right != null && head.right.val == nextVal) && check(head.right, root.next);

            return leftCheck || rightCheck; // check both left and right subtrees
        }

        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        int value = head.val;
        inorder(root, value, head);
        return flag;
    }
}
