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
    public int depth(TreeNode node){
        if(node==null)  return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return 1 + Math.max(left,right);
    }
    public TreeNode f(TreeNode root,int cur ,int depth){
        if(root==null)  return root;
        if(cur==depth && root!=null)    return root;
        TreeNode left = f(root.left,cur+1,depth);
        TreeNode right = f(root.right,cur+1,depth);
        if(left!=null && right!=null )  return root;
        if(left!=null)  return left;
        return right;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int d = depth(root);
        return f(root,0,d-1);
    }
}