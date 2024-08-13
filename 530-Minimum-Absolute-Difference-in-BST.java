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
    // int maxi = Integer.MAX_VALUE;
    ArrayList<Integer> arr = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)
            return ;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
        // maxi = Math.min(maxi,Math.abs(prev-root.val));
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int maxi = Integer.MAX_VALUE;
        for(int i=1;i<arr.size();i++)
            maxi = Math.min(Math.abs(arr.get(i)-arr.get(i-1)),maxi);
        return maxi;
    }
}