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
    public TreeNode f(TreeNode root){
        if(root==null)  return root;
        TreeNode left = null;
        if(root.left!=null){
           left = f(root.left);
        }
        if(left!=null){
            TreeNode temp = root.right;
            TreeNode dup = root.left;
            root.right = dup;
            root.left = null;
            TreeNode temp1 = dup;
            while(temp1!=null && temp1.right!=null){
                temp1 = temp1.right;
            }
            temp1.right = temp;
        }
        // TreeNode right = null;
        if(root.right!=null){
            f(root.right);
        }
        return root;
    }
    public void flatten(TreeNode root) {
        f(root);
    }
}