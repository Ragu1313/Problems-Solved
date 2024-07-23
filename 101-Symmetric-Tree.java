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
    public boolean issymm(TreeNode left1 ,TreeNode right1){
        if(left1==null && right1==null){
            return true;
        }
        if(left1==null || right1 == null|| left1.val!=right1.val)
            return false;
        return issymm(left1.left,right1.right) && issymm(left1.right,right1.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left!=null && root.right!=null)
            return issymm(root.left,root.right);
        if(root.left!=null || root.right!=null)
            return false;
        return true;
    }
}