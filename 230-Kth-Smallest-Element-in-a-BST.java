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
    private int count=0;
    private int result=0;
    public void smallest(TreeNode root,int k){
        if(root!=null){
            smallest(root.left,k);
            count++;
            if(count==k){
                result = root.val;
                return;}
            
            smallest(root.right,k);
        }   
    }
    public int kthSmallest(TreeNode root, int k) {
        smallest(root,k);
        return result;
    }
}