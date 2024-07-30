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
    private TreeNode a;
    public TreeNode insert(int i,int j,int arr[]){
       if(i<=j){
            int mid = i+(j-i)/2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = insert(i,mid-1,arr);
            node.right = insert(mid+1,j,arr);
            return node;
       }
       return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length/2;
        // TreeNode a = new TreeNode(nums[mid]);
        a = insert(0,nums.length-1,nums);
        return a;
    }
}