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

    public int[] f(TreeNode root,int maxi[]){
        if(root==null)  return new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int left[] = f(root.left,maxi);
        int right[] = f(root.right,maxi);
        if(left[0]==1 || right[0]==1)  return new int[]{1,0,0,0} ;
        else if(root.val<=left[2] || root.val>=right[1])  {
            System.out.println(root.val);
            return new int[]{1,0,0,0};
        }
        else{
            maxi[0] = Math.max(maxi[0],left[3]+right[3]+root.val);
            return new int[]{0,Math.min(root.val,left[1]),Math.max(root.val,right[2]),left[3]+right[3]+root.val};
        }   
    }

    public int maxSumBST(TreeNode root) {
        int maxi[] = new int[1];
        f(root,maxi); 
        return maxi[0];
    }
}