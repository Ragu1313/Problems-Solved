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
    int sum=0;
    public boolean isleaf(TreeNode root){
        if(root.left==null && root.right==null)
            return true;
        return false;
    }
    public void inorder(TreeNode root,int flag){
        if(root!=null){ 
            inorder(root.left,1);
            if(flag==1 && isleaf(root))
                sum+=root.val;
            inorder(root.right,0);
        }
        return;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        inorder(root,0);
        return sum;
    }
}