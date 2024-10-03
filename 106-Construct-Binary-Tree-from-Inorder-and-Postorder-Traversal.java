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
    public TreeNode build(int postorder[],int poststart,int postend,int instart,int inend,Map<Integer,Integer> map){
        if(instart>inend)   return null;
        TreeNode root = new TreeNode(postorder[poststart]);
        int getind = map.get(postorder[poststart]);
        int rsize = inend - getind;
        root.right = build(postorder,poststart-1,postend,getind+1,inend,map);
        root.left = build(postorder,poststart-1-rsize,postend,instart,getind-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        TreeNode root = build(postorder,postorder.length-1,0,0,inorder.length-1,map);
        return root;
    }
}