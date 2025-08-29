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
    TreeNode temp = null;
    public TreeNode helper(TreeNode node){
        if(node==null)  return null;
        if(node.left==null && node.right==null){
            return node;
        }
        TreeNode leftTail = helper(node.left);
        
        TreeNode rightTail = helper(node.right);
        if(leftTail!=null){
            TreeNode temp = node.right;
            node.right = node.left;
            leftTail.right = temp;
        }
        node.left = null;
        return rightTail!=null?rightTail:leftTail;

    }
    public void flatten(TreeNode root) {
        helper(root);
        return ;
    }
}