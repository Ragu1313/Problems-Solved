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
    List<Integer> res = new ArrayList<>();
    public void right(TreeNode root,int level){
       if(res.size()<=level){
            res.add(root.val);
       }
       if(root.right!=null)
       right(root.right,level+1);
       if(root.left!=null)
       right(root.left,level+1);
       return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root!=null){
            right(root,0);
        }
        return res;
    }
}