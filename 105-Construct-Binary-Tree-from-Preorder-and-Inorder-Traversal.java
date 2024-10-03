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
    public TreeNode build(int [] preorder,int prestart,int preend,int instart,int inend,Map<Integer,Integer> map){
        if(instart>inend )  return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inget = map.get(preorder[prestart]);
        int lsize = inget-instart;
        root.left = build(preorder,prestart+1,prestart+lsize,instart,inget-1,map);
        root.right = build(preorder,prestart+lsize+1,preend,inget+1,inend,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<preorder.length;i++)
            map.put(inorder[i],i);
        int prestart = 0;
        int preend = preorder.length;
        int instart = 0;
        int inend = inorder.length;
        TreeNode root = build(preorder,prestart,preend-1,instart,inend-1,map);
        return root;
    }
}