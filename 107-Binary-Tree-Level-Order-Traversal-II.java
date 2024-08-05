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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> a = new ArrayList<>();
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
                a.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);

            }
            res.add(a);
        }
        Collections.reverse(res);
        return res;
    }
}