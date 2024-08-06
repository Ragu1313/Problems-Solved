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
    public int inorder(TreeNode root){
        if(root==null){
            return 0;
        }
            int left = inorder(root.left);
            if(left==Integer.MIN_VALUE)
                return left;
            int right = inorder(root.right);
            if(right==Integer.MIN_VALUE)
                return right;
            if(Math.abs(left-right)>1)
                return Integer.MIN_VALUE;
            return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int res = inorder(root);
        if(res==Integer.MIN_VALUE ){
            return false;
        }
        return true;
    }
}