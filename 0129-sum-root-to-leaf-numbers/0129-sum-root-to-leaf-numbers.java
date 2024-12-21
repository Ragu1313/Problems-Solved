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
    int res= 0;
    public void f(TreeNode root,int sum){
        int temp;
        if(sum==0)
            temp = root.val;
        else temp = sum*10+root.val;
        if(root.left==null && root.right==null){
            System.out.println(temp);
            res +=temp;
        }
        if(root.left!=null){
            f(root.left,temp);
        }
        if(root.right!=null){
            f(root.right,temp);
        }
    }
    public int sumNumbers(TreeNode root) {
        f(root,0);
        return res;
    }
}