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
    public static ArrayList<Integer> a = new ArrayList<>();
    public void postTraversal(TreeNode root){
        if(root!=null){
        postTraversal(root.left);
        postTraversal(root.right);
        a.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        a = new ArrayList<Integer>();
        postTraversal(root);
        return a;
    }
}