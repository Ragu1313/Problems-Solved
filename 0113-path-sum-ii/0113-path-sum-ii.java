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

    List<List<Integer>> res = new ArrayList<>();

    // public void f1(TreeNode root,int tar){
    //     if(root!=null){
    //         f1(root.left,tar);
    //         f(root,tar,new ArrayList<>());
    //         f1(root.right,tar);
    //     }
    // }

    public void f(TreeNode root,int tar,List<Integer> arr){
        if(root==null)  return ;
        arr.add(root.val);
        tar = tar-root.val;
        if(tar==0 && root.left==null && root.right==null){
            res.add(new ArrayList<>(arr));
        }
        
        f(root.left,tar,arr); 

        
        f(root.right,tar,arr);
        
        arr.remove(arr.size()-1);
        
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        f(root,targetSum,new ArrayList<>());
        return res;

    }

}