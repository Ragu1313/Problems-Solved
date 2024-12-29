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
    int res = 0;
    public void f(TreeNode root,int tar){
        if(root!=null){
            // if(root.left!=null)
            f1(root,tar,0);
            f(root.left,tar);
            // if(root.right!=null)
            f(root.right,tar);
        }
    }
    public void f1(TreeNode root,int tar,long sum){
        if(root==null)  return ;
        // System.out.println(tar+" "+root.val);
        sum = sum+root.val;
        
        if(tar==sum){
            // System.out.println(res+" "+tar+" "+root.val);
            res++;
        }
        f1(root.left,tar,sum);
        f1(root.right,tar,sum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        f(root,targetSum);
        return res;
    }
}