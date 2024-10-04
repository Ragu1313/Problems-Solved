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
class Pair{
    public int num;
    public TreeNode root;
    public Pair(TreeNode root,int num){
        this.num = num;
        this.root = root;
    }
}
class Solution {
    
    public int inorder(TreeNode root){
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        if(root!=null)  q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = 0;
            int maxi = 0;
            int first = q.peek().num;
            for(int i=0;i<size;i++){
                int temp = q.peek().num-first;
                TreeNode node = q.peek().root;
                q.poll();
                if(i==0) min = temp;
                if(i==size-1)  maxi = temp;
                if(node.left!=null) q.add(new Pair(node.left,2*temp+1));
                if(node.right!=null) q.add(new Pair(node.right,2*temp+2));
            }
            ans = Math.max(ans,maxi-min+1);
        }
        return ans;
    }
    public int widthOfBinaryTree(TreeNode root) {
        return inorder(root);

    }
}