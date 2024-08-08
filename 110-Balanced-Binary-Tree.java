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
    int check(TreeNode root){
        if(root==null)
            return 0;
        int left = check(root.left);
        int right = check(root.right);
        if(Math.abs(left-right)>1)
            return -1;
        if(left==-1|| right==-1)
            return -1;
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int res = check(root);
        if(res==-1 ){
            return false;
        }
        return true;
    }
}