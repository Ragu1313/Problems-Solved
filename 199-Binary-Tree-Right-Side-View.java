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
    public void right(TreeNode root){
        // if(root!=null)
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // res.add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode temp = null;
            for(int i=0;i<size;i++){
                temp = q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            res.add(temp.val);
        }

    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root!=null){
            right(root);
        }
        return res;
    }
}