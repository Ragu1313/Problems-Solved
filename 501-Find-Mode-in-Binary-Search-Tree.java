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
    Map<Integer,Integer> a = new HashMap<>();
    int max=0;
    public void inorder(TreeNode node){
        if(node==null)
            return ;
        inorder(node.left);
        a.put(node.val,a.getOrDefault(node.val,0)+1);
        max = Math.max(max,a.get(node.val));
        inorder(node.right);
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        // int arr[] = new int[res.size()];
        int i=0;
        List<Integer> res = new ArrayList<>();
        for(int key:a.keySet()){
            if(a.get(key)==max)
                res.add(key);
        }
         
        return res.stream().mapToInt(x->x).toArray(); 
    }
}