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
    List<String> res = new ArrayList<>();
    public boolean isleaf(TreeNode a){
        if(a.left==null && a.right==null)
            return true;
        return false;
    }
    public void inorder(TreeNode root,String s){
        if(root==null){
            return ;
        }
        if(isleaf(root))
            res.add(s+\->\+String.valueOf(root.val));
        inorder(root.left,s+\->\+String.valueOf(root.val));
        // if(isleaf(root))
        //     res.add(s+\->\+String.valueOf(root.val));
        inorder(root.right,s+\->\+String.valueOf(root.val));
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root.left==null && root.right==null){
            res.add(String.valueOf(root.val));
            return res;
        }
        inorder(root.left,String.valueOf(root.val));
        inorder(root.right,String.valueOf(root.val));
        return res;
    }
}
