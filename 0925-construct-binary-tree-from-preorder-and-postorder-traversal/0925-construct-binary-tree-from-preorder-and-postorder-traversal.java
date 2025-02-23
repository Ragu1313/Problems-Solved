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
    int prei = 0;
    int posti = 0;
    public TreeNode f(int [] pre,int post[],int n){
        if(prei==n && posti==n) return null;
        TreeNode node = new TreeNode(pre[prei]);
        prei++;
        if(node.val!=post[posti]){
            node.left = f(pre,post,n);
        }
        if(node.val!=post[posti]){
            node.right = f(pre,post,n);
        }

        posti++;
        return node;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return f(preorder,postorder,preorder.length);
    }
}