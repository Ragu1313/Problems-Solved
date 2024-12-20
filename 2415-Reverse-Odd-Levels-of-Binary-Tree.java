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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)  return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        List<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            if(flag==0){
                while(size-->0){
                    TreeNode temp = q.poll();
                    if(temp.left!=null){
                        arr.add(temp.left.val);
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        arr.add(temp.right.val);
                        q.add(temp.right);
                    }
                    // System.out.println(arr);
                }
                
            }
            if(flag==1){
                // int c = arr.size()-1;
                while(size-->0){
                    TreeNode temp = q.poll();
                    temp.val = arr.get(size);
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }  
                    // System.out.println(arr);
                }
                arr = new ArrayList<>();
                // flag = 0;
            }
            flag = flag==0?1:0;
        }
        return root;
    }
}