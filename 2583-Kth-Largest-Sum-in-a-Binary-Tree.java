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
    PriorityQueue<Long> arr = new PriorityQueue<>(Collections.reverseOrder());
    public void kth(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                sum = sum+temp.val;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);  
                }
            }
            arr.add(sum);
        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        kth(root);
        while(!arr.isEmpty() && k>0){
            k--;
            if(k==0){
                return arr.poll();
            }
            arr.poll();
        }
        return -1;
    }
}