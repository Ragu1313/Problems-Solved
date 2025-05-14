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
    int mod = (int)(1e9+7);
    public long sum(TreeNode node){
        long sum = 0;
        if(node!=null){
            sum+=node.val;
            sum+=sum(node.left);
            sum+=sum(node.right);
        }
        return sum;
    }

    public long maxi(TreeNode node,long res[],long tot){
        if(node==null)  return 0;
        long temp = node.val;
        temp+=maxi(node.left,res,tot);
        temp+=maxi(node.right,res,tot);
        long prod = ((tot-temp)*temp);
        res[0] = Math.max(res[0],prod);
        // System.out.println(prod);
        return temp;
    }

    public int maxProduct(TreeNode root) {
        long tot = sum(root);
        long res[] = new long[1];
        maxi(root,res,tot);
        return (int)(res[0]%mod);
    }
}