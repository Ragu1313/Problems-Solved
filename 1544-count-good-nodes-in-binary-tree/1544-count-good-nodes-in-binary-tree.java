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
    public int f(TreeNode root,int preMax){
        if(root==null){
            return 0;
        }
        else if(root.val>=preMax){
            return 1 + f(root.left,root.val) + f(root.right,root.val);
        }
        else{
            return  f(root.left,preMax) + f(root.right,preMax);
        }
    }
    public int goodNodes(TreeNode root) {
        return f(root,Integer.MIN_VALUE);
    }
}