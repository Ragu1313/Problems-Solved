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
    public int maxi(TreeNode root,int arr[]){
        if(root==null)
            return 0;
        int left = Math.max(0, maxi(root.left,arr));
        int right = Math.max(0, maxi(root.right,arr));
        if(arr[0]<left+right+root.val)
            arr[0] = left+right+root.val;
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        if(root==null)
            return 0;
        arr[0] = Integer.MIN_VALUE;
        maxi(root,arr);
        if(arr[0]<root.val)
            arr[0] = root.val;
        return arr[0];
    }
}